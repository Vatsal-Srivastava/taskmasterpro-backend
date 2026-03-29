package com.practice.taskmaster.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sound.midi.Track;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseDateClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;

	private String name;
	@Column(unique = true)
	private String email;

	@JsonIgnore
	private String password;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonManagedReference
	private Set<Role> roles = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonManagedReference
	private Set<Task> tasks = new HashSet<>();
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonManagedReference
	private Set<SubTask> subtasks = new HashSet<>();
	
	@OneToMany(mappedBy = "createdBy", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@Column(nullable = true)
	@JsonManagedReference
    private Set<Task> createdTasks = new HashSet<>();

    // One-to-Many relationship for tasks where this user is the manager
    @OneToMany(mappedBy = "manager", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Column(nullable = true)
    @JsonManagedReference
    private Set<Task> managedTasks = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="user_id")
    private Set<Comment> comments = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name= "team_id", nullable = true)
	@JsonBackReference
	private Team team;
	
	@ManyToOne
	@JoinColumn(name = "project_id", nullable = true)
    @JsonBackReference
	private Project project;
	
	@OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonManagedReference
	private List<Notification> notifications = new ArrayList<>();

	public User() {
		super();
	}

	public User(Long id, String name, String email, String password, Set<Role> roles, Set<Task> tasks,
			Set<Task> createdTasks, Set<Task> managedTasks, Set<Comment> comments, Team team, Project project) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.tasks = tasks;
		this.createdTasks = createdTasks;
		this.managedTasks = managedTasks;
		this.comments = comments;
		this.team = team;
		this.project = project;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Task> getCreatedTasks() {
		return createdTasks;
	}

	public void setCreatedTasks(Set<Task> createdTasks) {
		this.createdTasks = createdTasks;
	}

	public Set<Task> getManagedTasks() {
		return managedTasks;
	}

	public void setManagedTasks(Set<Task> managedTasks) {
		this.managedTasks = managedTasks;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
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
	
	public Set<SubTask> getSubtasks() {
		return subtasks;
	}

	public void setSubtasks(Set<SubTask> subtasks) {
		this.subtasks = subtasks;
	}

	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password + ", email=" + email + ", roles=" + roles
				+ "]";
	}
}
