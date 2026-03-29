package com.practice.taskmaster.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subtasks")
public class SubTask extends BaseDateClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subtask_id")
	private Long id;

	private String title;

	// task assigned to
	@ManyToOne
	@JoinColumn(name = "assigned_user_id", nullable = true)
	@JsonBackReference
	private User user;

	public SubTask() {
		// TODO Auto-generated constructor stub
	}

	public SubTask(Long id, String title, User user) {
		super();
		this.id = id;
		this.title = title;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "SubTask [id=" + id + ", title=" + title + ", user=" + user + "]";
	}

}
