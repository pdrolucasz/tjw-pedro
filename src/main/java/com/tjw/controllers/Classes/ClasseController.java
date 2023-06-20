package com.tjw.controllers.Classes;

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

import com.tjw.dtos.response.ClasseDto;
import com.tjw.entities.Classe;
import com.tjw.servicesImpl.ClasseServiceImpl;

@RestController
@RequestMapping(value = "/classes")
public class ClasseController {
	@Autowired
	private ClasseServiceImpl service;

	@GetMapping
	public List<Classe> index() {
		List<Classe> response = service.findAll();
		return response;
	}

	@PostMapping
	public Classe store(@RequestBody Classe classe) {
		Classe response = service.save(classe);
		return response;
	}

	@GetMapping(value = "/{id}")
	public ClasseDto show(@PathVariable Long id) {
		ClasseDto response = service.findByIdAndStudents(id);
		return response;
	}

	@PutMapping(value = "/{id}")
	public void update(@PathVariable Long id, @RequestBody Classe classe) {
		service.update(id, classe);
	}

	@DeleteMapping(value = "/{id}")
	public void destroy(@PathVariable Long id) {
		service.deleteById(id);
	}
}
