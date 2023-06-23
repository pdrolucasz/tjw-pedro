package com.tjw.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alunos")
public class AlunosController {
	@GetMapping("")
	public String alunos(Model model) {
		model.addAttribute("currentPage", "alunos");
		return "alunos";
	}

	@GetMapping("/cadastrar")
	public String cadastrarAlunos(Model model) {
		model.addAttribute("currentPage", "alunos");
		return "cadastro-aluno";
	}
}
