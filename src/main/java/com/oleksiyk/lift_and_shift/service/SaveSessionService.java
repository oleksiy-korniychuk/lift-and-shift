package com.oleksiyk.lift_and_shift.service;

import com.oleksiyk.lift_and_shift.entity.*;
import com.oleksiyk.lift_and_shift.model.ExerciseLog;
import com.oleksiyk.lift_and_shift.model.WorkoutSession;
import com.oleksiyk.lift_and_shift.repository.LogRepository;
import com.oleksiyk.lift_and_shift.repository.WorkoutRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveSessionService {
    @Autowired
    private WorkoutRepository workoutRepository;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private EntityManager entityManager;

    public void saveSession(WorkoutSession session) {
        Workout workout = new Workout();
        User userProxy = entityManager.getReference(User.class, session.getUserId());
        Program programProxy = entityManager.getReference(Program.class, session.getProgramId());
        Block blockProxy = entityManager.getReference(Block.class, session.getBlockId());
        Day dayProxy = entityManager.getReference(Day.class, session.getDayId());

        workout.setUser(userProxy);
        workout.setProgram(programProxy);
        workout.setBlock(blockProxy);
        workout.setDay(dayProxy);
        workout.setDate(session.getWorkoutDate());
        workout.setNotes(session.getWorkoutNotes());

        Workout savedWorkout = workoutRepository.save(workout);

        List<Log> logs = session.getExerciseLogs().stream()
                        .map(exerciseLog -> mapToLog(exerciseLog, savedWorkout.getId()))
                        .toList();

        logRepository.saveAll(logs);
    }

    private Log mapToLog(ExerciseLog exerciseLog, Integer workoutId) {
        Log log = new Log();

        Workout workoutProxy = entityManager.getReference(Workout.class, workoutId);
        Exercise exerciseProxy = null;
        if(exerciseLog.getExerciseId() != null) {
            exerciseProxy = entityManager.getReference(Exercise.class, exerciseLog.getExerciseId());
        }

        log.setWorkout(workoutProxy);
        log.setExercise(exerciseProxy);
        log.setSetNumber(exerciseLog.getSetNumber());
        log.setReps(exerciseLog.getReps());
        log.setWeight(exerciseLog.getWeight());

        return log;
    }
}
