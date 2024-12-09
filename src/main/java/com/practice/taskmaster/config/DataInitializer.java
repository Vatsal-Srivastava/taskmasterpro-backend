package com.practice.taskmaster.config;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.taskmaster.model.Role;
import com.practice.taskmaster.model.RoleType;
import com.practice.taskmaster.model.User;
import com.practice.taskmaster.repository.RoleRepository;
import com.practice.taskmaster.repository.UserRepository;

@Component
public class DataInitializer implements CommandLineRunner {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;

	public DataInitializer(UserRepository userRepository, RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	@Override
	public void run(String... args) throws Exception {

		// Role Initialization
		if (roleRepository.count() == 0) {
			for (RoleType roletype : RoleType.values()) {
				Role role = new Role();
				role.setName(roletype);
				roleRepository.save(role);
			}
			System.out.println("Roles initialized in the database.");
		} else {
			System.out.println("Roles already exist in the database.");
		}

		// Admin User Initialization
		if (userRepository.count() == 0) {
			User admin = new User();
			admin.setEmail("admin@admin.com");
			admin.setName("Admin");
			admin.setPassword("admin");
			admin.setRoles(new HashSet<Role>(roleRepository.findAll()));
			userRepository.save(admin);
			System.out.println("Admin created in database.");
		} else {
			System.out.println("Admin already created in the database.");
		}

	}

}
