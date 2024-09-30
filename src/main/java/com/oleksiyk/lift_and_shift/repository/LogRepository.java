package com.oleksiyk.lift_and_shift.repository;

import com.oleksiyk.lift_and_shift.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log, Integer> {
}
