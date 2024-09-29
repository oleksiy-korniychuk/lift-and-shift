package com.oleksiyk.lift_and_shift.repository;

import com.oleksiyk.lift_and_shift.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
    List<Program> findByUser_Id(Integer userId);
}
