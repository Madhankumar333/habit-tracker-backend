package com.madhan.habit_tracker_backend.controller;

import com.madhan.habit_tracker_backend.model.HabitLog;
import com.madhan.habit_tracker_backend.service.HabitLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class HabitLogController {

    private final HabitLogService habitLogService;

    public HabitLogController(HabitLogService habitLogService) {
        this.habitLogService = habitLogService;
    }

    // MARK HABIT AS COMPLETED OR SKIPPED
    @PostMapping("/habit/{habitId}")
    public HabitLog markHabit(@PathVariable Long habitId, @RequestParam String status) {
        return habitLogService.markHabit(habitId, status);
    }

    // GET LOGS FOR A HABIT
    @GetMapping("/habit/{habitId}")
    public List<HabitLog> getLogs(@PathVariable Long habitId) {
        return habitLogService.getLogs(habitId);
    }
}
