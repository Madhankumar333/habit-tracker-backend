package com.madhan.habit_tracker_backend.repository;

import com.madhan.habit_tracker_backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
