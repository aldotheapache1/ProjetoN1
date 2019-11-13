package br.edu.ifms.ProjetoN1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {
	@GetMapping("/teste")
	public String testar() {
		return "PrimeiroTeste";
	}
	
	@GetMapping("/teste1")
	public String testarComBootStrap() {
		return "SegundoTeste";
	}
}
