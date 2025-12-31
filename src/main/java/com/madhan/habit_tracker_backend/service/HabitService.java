package com.madhan.habit_tracker_backend.service;

import com.madhan.habit_tracker_backend.dto.HabitRequestDTO;
import com.madhan.habit_tracker_backend.dto.HabitResponseDTO;
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

    public HabitResponseDTO createHabit(Long userId, HabitRequestDTO request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Habit habit = Habit.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .category(request.getCategory())
                .createdAt(LocalDateTime.now())
                .user(user)
                .build();

        Habit saved = habitRepository.save(habit);

        return HabitResponseDTO.builder()
                .id(saved.getId())
                .title(saved.getTitle())
                .description(saved.getDescription())
                .category(saved.getCategory())
                .createdAt(saved.getCreatedAt().toString())
                .userId(userId)
                .build();
    }
// Create habit for a user

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
