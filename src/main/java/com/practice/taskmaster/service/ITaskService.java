package com.practice.taskmaster.service;

import java.util.List;

import com.practice.taskmaster.dto.TaskDto;
import com.practice.taskmaster.model.TaskPriority;
import com.practice.taskmaster.model.TaskStatus;

public interface ITaskService {
	public TaskDto createTask(TaskDto task);

	public TaskDto getTaskById(Long taskId);

	public void deleteTask(Long taskId);

	public List<TaskDto> getAllTasks();

	public TaskDto updateTask(Long taskId, TaskDto task);

	// Status Based
	public List<TaskDto> getTasksByStatus(TaskStatus status);

	public List<TaskDto> getCompletedTasks();

	public List<TaskDto> getPendingTasks();

	// User Based
	public List<TaskDto> getTasksAssignedToUser(Long userId); // assigned

	public List<TaskDto> getTasksCreatedByUser(Long userId);

	public List<TaskDto> getTasksManagedByUser(Long userId);

	// Project / Team-specific
	List<TaskDto> getTasksByProject(Long projectId);

	List<TaskDto> getTasksByTeam(Long teamId);

	// 🔹 Priority / Due Date
	List<TaskDto> getTasksByPriority(TaskPriority priority);

	List<TaskDto> getOverdueTasks();

}
