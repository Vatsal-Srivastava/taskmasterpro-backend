package com.practice.taskmaster.service;

import java.util.List;
import java.util.Optional;

import com.practice.taskmaster.dto.RoleDto;
import com.practice.taskmaster.model.Role;
import com.practice.taskmaster.model.RoleType;

public interface IRoleService {
	Optional<RoleDto> findByName(RoleType name);

	List<RoleDto> getAllRole();
}
