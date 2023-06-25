package com.tjw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.entities.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByEmailContaining(String email);

	Optional<Student> findByEmail(String email);
}
