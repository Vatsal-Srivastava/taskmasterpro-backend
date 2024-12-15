package com.practice.taskmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.taskmaster.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
