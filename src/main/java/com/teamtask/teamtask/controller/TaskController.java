package com.teamtask.teamtask.controller;

import java.time.LocalDate;
import java.util.stream.Collectors;
import com.teamtask.teamtask.entity.Task;
import com.teamtask.teamtask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    // CREATE TASK
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // GET ALL TASKS
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // GET TASK BY ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {

        Task task = taskRepository
                .findById(id)
                .orElse(null);

        if (task != null) {

            task.setTitle(updatedTask.getTitle());

            task.setDescription(
                    updatedTask.getDescription()
            );

            task.setStatus(updatedTask.getStatus());

            task.setProject(updatedTask.getProject());

            task.setUser(updatedTask.getUser());

            return taskRepository.save(task);
        }

        return null;
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {

        taskRepository.deleteById(id);

        return "Task deleted successfully";
    }

    @GetMapping("/overdue")
    public List<Task> getOverdueTasks() {

        return taskRepository.findAll()
                .stream()
                .filter(task ->
                        task.getDueDate() != null
                                &&
                                task.getDueDate().isBefore(LocalDate.now())
                                &&
                                !task.getStatus().equals("COMPLETED")
                )
                .collect(Collectors.toList());
    }
}
