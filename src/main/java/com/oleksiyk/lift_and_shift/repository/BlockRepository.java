package com.oleksiyk.lift_and_shift.repository;

import com.oleksiyk.lift_and_shift.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlockRepository extends JpaRepository<Block, Integer> {
    List<Block> findByProgram_Id(Integer programId);
}
