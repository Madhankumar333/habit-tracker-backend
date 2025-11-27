package com.madhan.habit_tracker_backend.controller;

import com.madhan.habit_tracker_backend.model.Habit;
import com.madhan.habit_tracker_backend.service.HabitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habits")
public class HabitController {

    private final HabitService habitService;

    public HabitController(HabitService habitService) {
        this.habitService = habitService;
    }

    // CREATE HABIT FOR A USER
    @PostMapping("/user/{userId}")
    public Habit createHabit(@PathVariable Long userId, @RequestBody Habit habit) {
        return habitService.createHabit(userId, habit);
    }

    // GET ALL HABITS OF A USER
    @GetMapping("/user/{userId}")
    public List<Habit> getHabitsByUser(@PathVariable Long userId) {
        return habitService.getHabitsByUser(userId);
    }

    // GET HABIT BY ID
    @GetMapping("/{id}")
    public Habit getHabitById(@PathVariable Long id) {
        return habitService.getHabitById(id);
    }
}
