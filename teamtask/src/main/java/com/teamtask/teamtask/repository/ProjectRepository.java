package com.teamtask.teamtask.repository;

import com.teamtask.teamtask.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
