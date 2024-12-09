package com.practice.taskmaster.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.taskmaster.model.Role;
import com.practice.taskmaster.model.Task;
import com.practice.taskmaster.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	Optional<User> findByName(String name);
	
	Optional<User> findByEmail(String name);
	
	Optional<User> findByPassword(String name);
}