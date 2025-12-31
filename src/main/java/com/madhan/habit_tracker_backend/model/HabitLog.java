package com.madhan.habit_tracker_backend.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HabitLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    private String status; // COMPLETED or SKIPPED

    // MANY logs belong to ONE habit
    @ManyToOne
    @JoinColumn(name = "habit_id")
    private Habit habit;
}
