package com.tjw.controllers.Professors;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tjw.dtos.response.ProfessorDto;
import com.tjw.entities.Professor;
import com.tjw.servicesImpl.ProfessorServiceImpl;

@RestController
@RequestMapping(value = "/professors")
public class ProfessorController {
	@Autowired
	private ProfessorServiceImpl service;

	@GetMapping
	public List<Professor> index() {
		List<Professor> response = service.findAll();
		return response;
	}

	@PostMapping
	public Professor store(@RequestBody Professor professor) {
		Professor response = service.save(professor);
		return response;
	}

	@GetMapping(value = "/{id}")
	public ProfessorDto show(@PathVariable Long id) {
		ProfessorDto response = service.findByIdAndClasses(id);
		return response;
	}

	@PutMapping(value = "/{id}")
	public void update(@PathVariable Long id, @RequestBody Professor professor) {
		service.update(id, professor);
	}

	@DeleteMapping(value = "/{id}")
	public void destroy(@PathVariable Long id) {
		service.deleteById(id);
	}
}
