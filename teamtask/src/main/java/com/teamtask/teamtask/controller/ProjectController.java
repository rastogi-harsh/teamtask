package com.teamtask.teamtask.controller;

import com.teamtask.teamtask.entity.Project;
import com.teamtask.teamtask.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;

    // CREATE PROJECT
    @PostMapping
    public Project createProject(
            @RequestBody Project project
    ) {
        return projectRepository.save(project);
    }

    // GET ALL PROJECTS
    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // GET PROJECT BY ID
    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectRepository
                .findById(id)
                .orElse(null);
    }

    // UPDATE PROJECT
    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project updatedProject
    ) {

        Project project = projectRepository.findById(id).orElse(null);

        if (project != null) {

            project.setName(updatedProject.getName());

            project.setDescription(
                    updatedProject.getDescription()
            );

            return projectRepository.save(project);
        }

        return null;
    }

    // DELETE PROJECT
    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id
    ) {

        projectRepository.deleteById(id);

        return "Project deleted successfully";
    }
}
