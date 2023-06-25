package com.tjw.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tjw.entities.Classe;

public interface ClasseRepository extends JpaRepository<Classe, Long> {
	List<Classe> findByNameContaining(String email);
}
