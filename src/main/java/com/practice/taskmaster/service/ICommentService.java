package com.practice.taskmaster.service;

import com.practice.taskmaster.dto.CommentDto;

public interface ICommentService {
	// CRUD
	public CommentDto saveComment(CommentDto comment);

	public CommentDto getCommentById(Long commentId);
	
//	public 
}
