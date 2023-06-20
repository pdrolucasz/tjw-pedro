package com.tjw.servicesImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.tjw.dtos.response.ClasseDto;
import com.tjw.dtos.response.ProfessorDto;
import com.tjw.dtos.response.StudentDto;
import com.tjw.entities.Classe;
import com.tjw.entities.Student;
import com.tjw.serviceExceptions.NotFoundException;
import com.tjw.services.ClasseService;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

public class ClasseServiceImpl extends SimpleJpaRepository<Classe, Long> implements ClasseService {
	public ClasseServiceImpl(EntityManager entityManager) {
		super(Classe.class, entityManager);
	}

	@Override
	public Classe findByIdVerify(Long id) {
		return this.findById(id).orElseThrow(() -> new NotFoundException(id));
	}

	@Override
	@Transactional
	public void update(Long id, Classe classeDto) {
		Classe classe = this.findByIdVerify(id);

		classe.setName(classeDto.getName());
		if (classeDto.getProfessor() != null) {
			classe.setProfessor(classeDto.getProfessor());
		}

		this.save(classe);
	}

	@Override
	public ClasseDto findByIdAndStudents(Long id) {
		Classe classe = this.findByIdVerify(id);
		ClasseDto classeDto = new ClasseDto();
		classeDto.setId(classe.getId());
		classeDto.setName(classe.getName());

		ProfessorDto professorDto = new ProfessorDto();
		professorDto.setId(classe.getProfessor().getId());
		professorDto.setName(classe.getProfessor().getName());
		professorDto.setEmail(classe.getProfessor().getEmail());

		classeDto.setProfessor(professorDto);

		Set<StudentDto> studentsDto = new HashSet<>();
		for (Student student : classe.getStudents()) {
			StudentDto studentDto = new StudentDto();
			studentDto.setId(student.getId());
			studentDto.setName(student.getName());
			studentDto.setEmail(student.getEmail());
			studentsDto.add(studentDto);
		}

		classeDto.setStudents(studentsDto);

		return classeDto;
	}
}
