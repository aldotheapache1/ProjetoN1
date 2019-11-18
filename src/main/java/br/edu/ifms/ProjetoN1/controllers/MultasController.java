package br.edu.ifms.ProjetoN1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.ProjetoN1.model.Multa;
import br.edu.ifms.ProjetoN1.service.CarroService;
import br.edu.ifms.ProjetoN1.service.InfracaoService;
import br.edu.ifms.ProjetoN1.service.MultaService;

@Controller
public class MultasController {
	@Autowired
	private MultaService multaService;
	@Autowired
	private InfracaoService infracaoService;
	@Autowired
	private CarroService carroService;

	@GetMapping("/multas")
	public ModelAndView listaInfracoes() {
		ModelAndView mv = new ModelAndView("ListaMultas");
		
		mv.addObject("multas", multaService.buscarTodos());
		mv.addObject(new Multa());
		mv.addObject("infracoes", infracaoService.buscarTodos());
		mv.addObject("carros", carroService.buscarTodos());
		
		return mv;
	}
	
	@PostMapping("/multas")
	public String salvar(Multa multa) {
		multaService.salvar(multa);
		return "redirect:/multas";
	}

	@GetMapping("/multas/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("EditarMulta");
		mv.addObject("infracoes", infracaoService.buscarTodos());		
		mv.addObject(multaService.procurar(id));
		return mv;
	}
	
	@GetMapping("/multas/deletar/{id}")
	public String excluir(@PathVariable("id") Long id) {
		multaService.deletar(id);
		return "redirect:/multas";
	}
	
	@GetMapping("/multas/deletar/confirmacao/{id}")
	public ModelAndView excluirPorOutraPagina(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("ExcluirMulta");
		mv.addObject(multaService.procurar(id));
		return mv;
	}
	
	@DeleteMapping("/multas/deletar/{id}")
	public String excluirPorOutraPagina2(@PathVariable("id") Long id) {
		multaService.deletar(id);
		return "redirect:/carros";
	}	
}
