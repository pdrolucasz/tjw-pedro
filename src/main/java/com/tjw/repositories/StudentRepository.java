package com.tjw.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
