package com.oleksiyk.lift_and_shift.model;

import java.time.LocalDate;
import java.util.List;

public class WorkoutSession {
    private Integer userId;
    private Integer programId;
    private Integer blockId;
    private Integer dayId;
    private LocalDate workoutDate;
    private String workoutNotes;
    private List<ExerciseLog> exerciseLogs;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public Integer getDayId() {
        return dayId;
    }

    public void setDayId(Integer dayId) {
        this.dayId = dayId;
    }

    public LocalDate getWorkoutDate() {
        return workoutDate;
    }

    public void setWorkoutDate(LocalDate workoutDate) {
        this.workoutDate = workoutDate;
    }

    public String getWorkoutNotes() {
        return workoutNotes;
    }

    public void setWorkoutNotes(String workoutNotes) {
        this.workoutNotes = workoutNotes;
    }

    public List<ExerciseLog> getExerciseLogs() {
        return exerciseLogs;
    }

    public void setExerciseLogs(List<ExerciseLog> exerciseLogs) {
        this.exerciseLogs = exerciseLogs;
    }

}
