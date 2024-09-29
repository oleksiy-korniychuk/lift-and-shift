package com.oleksiyk.lift_and_shift.repository;

import com.oleksiyk.lift_and_shift.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayRepository extends JpaRepository<Day, Integer> {
    List<Day> findByBlock_Id(Integer blockId);
}
