package com.madhan.habit_tracker_backend.repository;

import com.madhan.habit_tracker_backend.model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitLogRepository extends JpaRepository<HabitLog, Long> {
}
