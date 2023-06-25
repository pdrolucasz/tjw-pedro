package com.tjw.entities;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
// import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "classes")
public class Classe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// @Setter(AccessLevel.NONE)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@ManyToOne
	@JoinColumn(name = "professor_id")
	private Professor professor;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "students_classes", joinColumns = @JoinColumn(name = "classe_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
	@JsonIgnore
	private Set<Student> students;

	@Deprecated
	public Classe() {
	}
}
