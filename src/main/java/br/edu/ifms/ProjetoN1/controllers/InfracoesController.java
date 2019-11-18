package br.edu.ifms.ProjetoN1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.ProjetoN1.model.Infracao;
import br.edu.ifms.ProjetoN1.service.InfracaoService;

@Controller
public class InfracoesController {
	@Autowired
	private InfracaoService infracaoService;
	
	@GetMapping("/infracoes")
	public ModelAndView listaInfracoes() {
		ModelAndView mv = new ModelAndView("ListaInfracoes");
		
		mv.addObject("infracoes", infracaoService.buscarTodos());
		mv.addObject(new Infracao());
		
		return mv;
	}
	
	@PostMapping("/infracoes")
	public String salvar(Infracao infracao) {
		infracaoService.salvar(infracao);
		return "redirect:/infracoes";
	}
	
	@GetMapping("/infracoes/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("EditaInfracao");
		mv.addObject(infracaoService.procurar(id));
		return mv;
	}
	
	@GetMapping("/infracoes/deletar/{id}")
	public String excluir(@PathVariable("id") Long id) {
		infracaoService.deletar(id);
		return "redirect:/infracoes";
	}
	
	@GetMapping("/infracoes/deletar/confirmacao/{id}")
	public ModelAndView excluirPorOutraPagina(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("ExcluirInfracao");
		mv.addObject(infracaoService.procurar(id));
		return mv;
	}
	
	@DeleteMapping("/infracoes/deletar/{id}")
	public String excluirPorOutraPagina2(@PathVariable("id") Long id) {
		infracaoService.deletar(id);
		return "redirect:/carros";
	}	
	
}
