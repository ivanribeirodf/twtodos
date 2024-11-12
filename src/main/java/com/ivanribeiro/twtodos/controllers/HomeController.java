package com.ivanribeiro.twtodos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView home() {
		var modelAndView = new ModelAndView("home");
		modelAndView.addObject("nome","Ivan Ribeiro");
		var alunos = List.of("aluno 01","aluno 02","aluno 03","aluno 04","aluno 05");
		modelAndView.addObject("alunos", alunos);
		modelAndView.addObject("ehProgramador", false);
		return modelAndView;
	}
}
