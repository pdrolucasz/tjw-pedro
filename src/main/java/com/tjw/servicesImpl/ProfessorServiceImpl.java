package com.tjw.servicesImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.tjw.dtos.response.ClasseDto;
import com.tjw.dtos.response.ProfessorDto;
import com.tjw.entities.Classe;
import com.tjw.entities.Professor;
import com.tjw.serviceExceptions.NotFoundException;
import com.tjw.services.ProfessorService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class ProfessorServiceImpl extends SimpleJpaRepository<Professor, Long> implements ProfessorService {
	public ProfessorServiceImpl(EntityManager entityManager) {
		super(Professor.class, entityManager);
	}

	@Override
	public Professor findByIdVerify(Long id) {
		return this.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	@Override
	@Transactional
	public void update(Long id, Professor professorDto) {
		Professor professor = this.findByIdVerify(id);

		professor.setName(professorDto.getName());
		professor.setEmail(professorDto.getEmail());

		this.save(professor);
	}

	@Override
	public ProfessorDto findByIdAndClasses(Long id) {
		Professor professor = this.findByIdVerify(id);

		ProfessorDto professorDto = new ProfessorDto();
		professorDto.setId(professor.getId());
		professorDto.setName(professor.getName());
		professorDto.setEmail(professor.getEmail());

		List<ClasseDto> classesDto = new ArrayList<>();
		for (Classe classe : professor.getClasses()) {
			ClasseDto classeDto = new ClasseDto();
			classeDto.setId(classe.getId());
			classeDto.setName(classe.getName());
			classesDto.add(classeDto);
		}

		professorDto.setClasses(classesDto);

		return professorDto;
	}
}