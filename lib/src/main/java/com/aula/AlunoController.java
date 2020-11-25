package com.aula;

import java.util.Map;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.aluno.Aluno;
import com.aula.aluno.AlunoService;

@Controller
public class AlunoController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/aluno")
	public String cadastrar(Model model) {
		model.addAttribute("aluno", new Aluno());
		return "formalu";
	}
	
	@PostMapping("/aluno")
	public String inserirAluno(@ModelAttribute Aluno aluno, Model model) {
		model.addAttribute("aluno", aluno);
		AlunoService adao = context.getBean(AlunoService.class);
		adao.insert(aluno);
		return "alunosucesso";
	}
	
	@GetMapping("/perfil/{id}")
	public String perfil(@PathVariable("id") int id, Model model) {
		AlunoService adao = context.getBean(AlunoService.class);
		Map<String,Object> registro = adao.getAluno(id);
		model.addAttribute("aluno", new Aluno((String)registro.get("nome"), registro.get("ra")));		
		return "alunosucesso";
	}
}