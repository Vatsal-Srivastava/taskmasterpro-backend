package com.practice.taskmaster.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task extends BaseDateClass {

	// id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Long id;
	
	private String name;

	// task assigned to user(one to many) title
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = true)
	@JsonBackReference
	private User user;

	// task description
	private String description;

	// status (enum - new ,in progress, closed )
	@Enumerated(EnumType.STRING)
	private TaskStatus status;

	// priority (low, medium, High)
	@Enumerated(EnumType.STRING)
	private TaskPriority priority;

	// comments (one to many)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "task_id")// Foreign key in the "comments" table
	private Set<Comment> comments = new HashSet<>();

	// created by which user
	@ManyToOne
	@JoinColumn(name = "created_by_user_id", nullable = false)
	@JsonBackReference
	private User createdBy;

	// under which manager
	@ManyToOne
	@JoinColumn(name = "manager_user_id", nullable = true)
	@JsonBackReference
	private User manager;

	// specific team
	@ManyToOne
	@JoinColumn(name = "team_id", nullable = true)
	@JsonBackReference
	private Team team;

	// which Project
	@ManyToOne
	@JoinColumn(name = "project_id", nullable = false)
	@JsonBackReference
	private Project project;

	// Due Date
	@Column(name = "due_date", nullable = true)
	private LocalDate dueDate;
	// tags Optional

	public Task() {
		super();
	}

	public Task(Long id, User user, String description, TaskStatus status, TaskPriority priority, Set<Comment> comments,
			User createdBy, User manager, Team team, Project project, LocalDate dueDate) {
		super();
		this.id = id;
		this.user = user;
		this.description = description;
		this.status = status;
		this.priority = priority;
		this.comments = comments;
		this.createdBy = createdBy;
		this.manager = manager;
		this.team = team;
		this.project = project;
		this.dueDate = dueDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public TaskPriority getPriority() {
		return priority;
	}

	public void setPriority(TaskPriority priority) {
		this.priority = priority;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "Task [id=" + id + ", user=" + user + ", description=" + description + ", status=" + status
				+ ", priority=" + priority + ", comments=" + (comments != null ? toString(comments, maxLen) : null)
				+ ", createdBy=" + createdBy + ", manager=" + manager + ", team=" + team + ", project=" + project
				+ ", dueDate=" + dueDate + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

}
