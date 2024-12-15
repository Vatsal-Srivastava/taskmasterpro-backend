package com.practice.taskmaster.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.taskmaster.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("SELECT c FROM Comment c JOIN Task t WHERE t.id=:taskId ORDER BY c.createdAt DESC")
	Set<Comment> findByTaskId(@Param("taskId") Long taskId);

	// Native query since user_id is not Explicitly mentioned in comments entity but
	// created as foreign key from user entity
	@Query(value = "SELECT * FROM comments WHERE user_id = :userId", nativeQuery = true)
	Set<Comment> findByCreatedByUserId(@Param("userId") Long userId);
}
