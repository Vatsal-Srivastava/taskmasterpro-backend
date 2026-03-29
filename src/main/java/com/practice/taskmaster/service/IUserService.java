package com.practice.taskmaster.service;

import java.util.List;
import java.util.Set;

import com.practice.taskmaster.dto.TaskDto;
import com.practice.taskmaster.dto.UserDto;
import com.practice.taskmaster.model.Role;

public interface IUserService {
	
	public UserDto createUser(UserDto user) throws Exception;

	public UserDto getUserById(Long userId);
	
	public List<UserDto> getAllUsers();
	
	public UserDto updateUser(Long userId, UserDto user);
	
	public void deleteUser(Long userId);
	
	public Set<Role> getRoleByUserId(Long userId);
	
	public Set<TaskDto> getTaskByUserId(Long userId);
	
	//assign role to user
}
