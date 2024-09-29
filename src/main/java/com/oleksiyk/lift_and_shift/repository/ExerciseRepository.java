package com.oleksiyk.lift_and_shift.repository;

import com.oleksiyk.lift_and_shift.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {
    List<Exercise> findByDayId(Integer dayId);
}
