package com.madhan.habit_tracker_backend.service;

import com.madhan.habit_tracker_backend.model.Habit;
import com.madhan.habit_tracker_backend.model.HabitLog;
import com.madhan.habit_tracker_backend.repository.HabitLogRepository;
import com.madhan.habit_tracker_backend.repository.HabitRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HabitLogService {

    private final HabitLogRepository habitLogRepository;
    private final HabitRepository habitRepository;

    public HabitLogService(HabitLogRepository habitLogRepository, HabitRepository habitRepository) {
        this.habitLogRepository = habitLogRepository;
        this.habitRepository = habitRepository;
    }

    // Mark habit completed for today's date
    public HabitLog markHabit(Long habitId, String status) {

        Habit habit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Habit not found"));

        HabitLog log = HabitLog.builder()
                .habit(habit)
                .date(LocalDate.now())
                .status(status)
                .build();

        return habitLogRepository.save(log);
    }

    // Get logs for a habit
    public List<HabitLog> getLogs(Long habitId) {
        return habitLogRepository.findAll()
                .stream()
                .filter(l -> l.getHabit().getId().equals(habitId))
                .toList();
    }
}
