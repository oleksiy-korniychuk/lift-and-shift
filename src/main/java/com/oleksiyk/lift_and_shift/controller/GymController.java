package com.oleksiyk.lift_and_shift.controller;

import com.oleksiyk.lift_and_shift.entity.*;
import com.oleksiyk.lift_and_shift.model.WorkoutSession;
import com.oleksiyk.lift_and_shift.repository.BlockRepository;
import com.oleksiyk.lift_and_shift.repository.DayRepository;
import com.oleksiyk.lift_and_shift.repository.ExerciseRepository;
import com.oleksiyk.lift_and_shift.repository.ProgramRepository;
import com.oleksiyk.lift_and_shift.service.SaveSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GymController {

    @Autowired
    private ExerciseRepository exerciseRepository;
    @Autowired
    private ProgramRepository programRepository;
    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private DayRepository dayRepository;
    @Autowired
    private SaveSessionService saveSessionService;

    @GetMapping(value = "/program")
    public List<Program> getProgramsByUserId(@RequestParam(name = "user_id") Integer userId) {
        return programRepository.findByUser_Id(userId);
    }

    @GetMapping(value = "/block")
    public List<Block> getBlocksByProgramId(@RequestParam(name = "program_id") Integer programId) {
        return blockRepository.findByProgram_Id(programId);
    }

    @GetMapping(value = "/day")
    public List<Day> getDaysByBlockId(@RequestParam(name = "block_id") Integer blockId) {
        return dayRepository.findByBlock_Id(blockId);
    }

    @GetMapping(value = "/exercise")
    public List<Exercise> getExercisesByDay(@RequestParam(name = "day_id") Integer dayId) {
        return exerciseRepository.findByDayId(dayId);
    }

    @PostMapping(value = "/session")
    public String getExercisesByDay(@RequestBody WorkoutSession session) {
        saveSessionService.saveSession(session);
        return "Saved";
    }
}
