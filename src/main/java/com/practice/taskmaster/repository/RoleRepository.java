package com.practice.taskmaster.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practice.taskmaster.model.Role;
import com.practice.taskmaster.model.RoleType;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Optional<Role> findByName(RoleType Role);
	
	@Query("SELECT r FROM Role r JOIN r.users u WHERE u.id=:userId")
	Set<Role> findRolesByUserId(@Param("userId") Long userId);
	
}
