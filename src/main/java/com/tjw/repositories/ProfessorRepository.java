package com.tjw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
