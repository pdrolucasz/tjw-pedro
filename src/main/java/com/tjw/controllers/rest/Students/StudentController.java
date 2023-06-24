package com.tjw.controllers.rest.Students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tjw.dtos.response.StudentDto;
import com.tjw.entities.Student;
import com.tjw.servicesImpl.StudentServiceImpl;

@RestController
@RequestMapping(value = "/students")
public class StudentController {
	@Autowired
	private StudentServiceImpl service;

	@GetMapping
	public List<Student> index() {
		List<Student> response = service.findAll();
		return response;
	}

	@GetMapping("/search")
	public List<Student> searchByEmail(@RequestParam("email") String email) {
		return service.searchByEmail(email);
	}

	@PostMapping
	public ModelAndView store(Student student) {
		service.save(student);
		return new ModelAndView("redirect:/alunos");
	}

	@GetMapping(value = "/{id}")
	public StudentDto show(@PathVariable Long id) {
		StudentDto response = service.findByIdAndClasses(id);
		return response;
	}

	@PutMapping(value = "/{id}")
	public ModelAndView update(@PathVariable Long id, Student student) {
		service.update(id, student);
		return new ModelAndView("redirect:/alunos");
	}

	@DeleteMapping(value = "/{id}")
	public void destroy(@PathVariable Long id) {
		service.deleteById(id);
	}
}
