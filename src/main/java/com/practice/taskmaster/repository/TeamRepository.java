package com.practice.taskmaster.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.taskmaster.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
