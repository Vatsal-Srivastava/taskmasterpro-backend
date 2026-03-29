package com.practice.taskmaster.service;

import java.util.List;

import com.practice.taskmaster.dto.ProjectDto;
import com.practice.taskmaster.model.User;

public interface IProjectService {
	public ProjectDto createProject(ProjectDto project);

	public ProjectDto updateProject(Long projectId, ProjectDto project);

	public void deleteProject(Long projectId);

	public ProjectDto getProjectById(Long projectId);

	public User getProjectManager(Long projectId);

	public List<ProjectDto> getAllProjects();

	public void addUserToProject(Long projectId, Long userId);

	public void removeUserFromProject(Long projectId, Long userId);
}
