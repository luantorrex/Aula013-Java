package com.aula;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
	@GetMapping("/ola/{nm}")
	public String ola(@PathVariable("nm") String nm, Model model) {
		//"nome" corresponde ao ${nome} do html
		model.addAttribute("nome",nm);
		//nome da pagina html
		return "principal";
	}
	
	@GetMapping("/")
	public String principal(Model model) {
		String nm = "Mundo!";
		//"nome" corresponde ao ${nome} do html
		model.addAttribute("nome",nm);
		//nome da pagina html
		return "principal";
	}
	
	@GetMapping("/outro")
	public String outro(Model model){
		return "outro";
	}
}
