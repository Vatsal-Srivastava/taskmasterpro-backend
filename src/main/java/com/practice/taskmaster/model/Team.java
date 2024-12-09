package com.practice.taskmaster.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "teams")
public class Team extends BaseDateClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_id")
	private long id;

	private String name;

	@OneToMany(mappedBy = "team", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonManagedReference
	private Set<User> users = new HashSet<>();

	@OneToOne(mappedBy = "team", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JsonBackReference
	private Project project;
	
	@OneToMany(mappedBy = "team", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JsonManagedReference
	private Set<Task> teamTasks = new HashSet<>();

	public Team() {
		super();
	}

	public Team(long id, String name, Set<User> users, Project project) {
		super();
		this.id = id;
		this.name = name;
		this.users = users;
		this.project = project;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}
