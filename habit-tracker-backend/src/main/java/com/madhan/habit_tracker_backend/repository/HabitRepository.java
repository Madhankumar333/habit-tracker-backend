package com.madhan.habit_tracker_backend.repository;

import com.madhan.habit_tracker_backend.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitRepository extends JpaRepository<Habit, Long> {
}
