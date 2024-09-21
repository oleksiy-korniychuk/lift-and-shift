package com.oleksiyk.lift_and_shift.repository;

import com.oleksiyk.lift_and_shift.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
