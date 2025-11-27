package com.madhan.habit_tracker_backend.service;

import com.madhan.habit_tracker_backend.model.Habit;
import com.madhan.habit_tracker_backend.model.User;
import com.madhan.habit_tracker_backend.repository.HabitRepository;
import com.madhan.habit_tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;

    public HabitService(HabitRepository habitRepository, UserRepository userRepository) {
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
    }

    // Create habit for a user
    public Habit createHabit(Long userId, Habit habit) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        habit.setUser(user);
        habit.setCreatedAt(LocalDateTime.now());

        return habitRepository.save(habit);
    }

    // Get all habits of a user
    public List<Habit> getHabitsByUser(Long userId) {
        return habitRepository.findAll()
                .stream()
                .filter(h -> h.getUser().getId().equals(userId))
                .toList();
    }

    // Get habit by ID
    public Habit getHabitById(Long id) {
        return habitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Habit not found"));
    }
}
