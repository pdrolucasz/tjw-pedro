package com.tjw.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.dtos.response.StudentDto;
import com.tjw.entities.Student;

public interface StudentService extends JpaRepository<Student, Long> {
	public Student findByIdVerify(Long id);

	public void update(Long id, Student studentDto);

	public StudentDto findByIdAndClasses(Long id);
}
