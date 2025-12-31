package com.madhan.habit_tracker_backend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HabitResponseDTO {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String createdAt;
    private Long userId;
}
