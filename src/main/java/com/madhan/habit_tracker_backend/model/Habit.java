package com.madhan.habit_tracker_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String category;

    private LocalDateTime createdAt;

    // MANY habits belong to ONE user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
