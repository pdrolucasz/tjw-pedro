package com.tjw.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.dtos.response.StudentDto;
import com.tjw.entities.Student;

public interface StudentService extends JpaRepository<Student, Long> {
	public Student findByIdVerify(Long id);

	public void update(Long id, Student student);

	public StudentDto findByIdAndClasses(Long id);

	List<Student> searchByEmail(String email);

	Student findOneByEmail(String email);
}
