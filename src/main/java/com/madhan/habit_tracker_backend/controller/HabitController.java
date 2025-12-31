package com.madhan.habit_tracker_backend.controller;

import com.madhan.habit_tracker_backend.dto.HabitRequestDTO;
import com.madhan.habit_tracker_backend.dto.HabitResponseDTO;
import com.madhan.habit_tracker_backend.service.HabitService;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    // CREATE HABIT FOR A USER  (UPDATED METHOD)
    @PostMapping("/user/{userId}")
    public HabitResponseDTO createHabit(
            @PathVariable Long userId,
            @RequestBody @Valid HabitRequestDTO request) {

        return habitService.createHabit(userId, request);
    }

    // GET ALL HABITS OF A USER (still returns entity for now)
    @GetMapping("/user/{userId}")
    public List<?> getHabitsByUser(@PathVariable Long userId) {
        return habitService.getHabitsByUser(userId);
    }

    // GET HABIT BY ID
    @GetMapping("/{id}")
    public Object getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id);
    }
}
