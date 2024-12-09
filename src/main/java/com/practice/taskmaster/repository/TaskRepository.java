package com.practice.taskmaster.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.taskmaster.model.Task;
import com.practice.taskmaster.model.TaskPriority;
import com.practice.taskmaster.model.TaskStatus;
import com.practice.taskmaster.model.Team;

public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> findByName(String name);

	@Query("SELECT t FROM Task t WHERE t.user.id=:userId")
	Set<Task> findByUserId(@Param("userId") Long userId);

	@Query("SELECT t FROM Task t WHERE t.createdBy.id=:userId")
	Set<Task> findCreatedTasksByUserId(@Param("userId") Long userId);

	// Priority
	@Query("SELECT t FROM Task t WHERE t.priority=:priority")
	Set<Task> findByPriority(@Param("priority") TaskPriority priority);

	@Query("SELECT t FROM Task t WHERE t.priority=:priority AND t.user.id=:userId")
	Set<Task> findByPriorityAndUserId(@Param("priority") TaskPriority priority, @Param("userId") Long userId);

	// status
	@Query("SELECT t FROM Task t WHERE t.status=:status")
	Set<Task> findByStatus(@Param("status") TaskStatus status);
	
	//Team
	@Query("SELECT t FROM Task t WHERE t.team.id=:teamId")
	Set<Task> findByTeam(@Param("teamId") Long teamId);
}
