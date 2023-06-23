package com.tjw.controllers.rest.Classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tjw.servicesImpl.ClasseServiceImpl;

@RestController
@RequestMapping(value = "/classes")
public class StudentsToClasseController {
	@Autowired
	private ClasseServiceImpl service;

	@PutMapping(value = "/alunos/{id}")
	public String update(@PathVariable Long id, Long[] students) {
		service.enroll(id, students);
		return "redirect:/turmas";
	}
}
