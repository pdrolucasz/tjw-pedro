package com.tjw.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.dtos.response.ClasseDto;
import com.tjw.entities.Classe;

public interface ClasseService extends JpaRepository<Classe, Long> {
	public Classe findByIdVerify(Long id);

	public void update(Long id, Classe classe);

	public ClasseDto findByIdAndStudents(Long id);

	public void enroll(Long id, Long[] students);

	List<Classe> searchByName(String name);
}
