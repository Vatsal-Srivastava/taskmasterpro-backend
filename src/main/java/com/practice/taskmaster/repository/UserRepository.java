package com.practice.taskmaster.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.taskmaster.model.Role;
import com.practice.taskmaster.model.Task;
import com.practice.taskmaster.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);

	Optional<User> findByEmail(String email); // use this for login

	// Optional<User> findByPassword(String name); //Not recommended You never do
	// SELECT u FROM User u WHERE u.password = ? //What was i thinking

	@Query("SELECT u FROM User u  WHERE u.team.id=:teamId")
	Page<User> findByTeamId(@Param("teamId") Long teamId, Pageable pageable);

	@Query("SELECT u FROM User u WHERE u.project.id=:projectId")
	Page<User> findByProjectId(@Param("projectId") Long projectId, Pageable pageable);
}
