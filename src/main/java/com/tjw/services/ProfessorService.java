package com.tjw.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.dtos.response.ProfessorDto;
import com.tjw.entities.Professor;

public interface ProfessorService extends JpaRepository<Professor, Long> {
	public Professor findByIdVerify(Long id);

	public void update(Long id, Professor professorDto);

	public ProfessorDto findByIdAndClasses(Long id);
}
