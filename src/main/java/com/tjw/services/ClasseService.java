package com.tjw.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.dtos.response.ClasseDto;
import com.tjw.entities.Classe;

public interface ClasseService extends JpaRepository<Classe, Long> {
	public Classe findByIdVerify(Long id);

	public void update(Long id, Classe classeDto);

	public ClasseDto findByIdAndStudents(Long id);
}
