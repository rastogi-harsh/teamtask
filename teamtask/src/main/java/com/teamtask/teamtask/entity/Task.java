package com.teamtask.teamtask.entity;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String status;

    private LocalDate dueDate;
    // MANY TASKS CAN BELONG TO ONE PROJECT
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // MANY TASKS CAN BE ASSIGNED TO ONE USER
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Task() {
    }
}
