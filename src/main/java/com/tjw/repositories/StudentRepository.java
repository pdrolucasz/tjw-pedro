package com.tjw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.entities.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByEmailContaining(String email);
}
