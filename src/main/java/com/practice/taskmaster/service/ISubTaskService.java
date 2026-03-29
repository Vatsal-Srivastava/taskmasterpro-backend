package com.practice.taskmaster.service;

import java.util.List;
import java.util.Optional;

import com.practice.taskmaster.dto.SubTaskDto;

public interface ISubTaskService {
	// CRUD
	public SubTaskDto create(SubTaskDto subtask);

	public Optional<SubTaskDto> getSubTaskById(Long subtaskId);

	public SubTaskDto updateSubTask(Long subtaskId, SubTaskDto subtask);

	public void deleteSubtask(Long subtaskId);

	public List<SubTaskDto> getAllSubTasks();

	List<SubTaskDto> getSubTasksByUserId(Long userId);

	List<SubTaskDto> getSubTasksByTaskId(Long taskId);
}
