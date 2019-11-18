package br.edu.ifms.ProjetoN1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.edu.ifms.ProjetoN1.model.Carro;
import br.edu.ifms.ProjetoN1.model.Multa;
import br.edu.ifms.ProjetoN1.service.CarroService;
import br.edu.ifms.ProjetoN1.service.MultaService;

@Controller
public class CarrosController {
	@Autowired
	private CarroService carroService;
	
	@Autowired
	private MultaService multaService;
	
	@GetMapping("/carros")
	public ModelAndView listaCarros() {
		ModelAndView mv = new ModelAndView("ListaCarros");
		
		mv.addObject("carros", carroService.buscarTodos());
		mv.addObject(new Carro());
		
		return mv;
	}
	
	@GetMapping("/carros/verificar/{id}")
	public ModelAndView verificarCarro(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("VerificarCarro");
		mv.addObject("carro", carroService.procurar(id));
		mv.addObject("totalPontos", carroService.calculaTotalPontos(carroService.procurar(id)));
		mv.addObject("valorTotal", carroService.calculaValorTotal(carroService.procurar(id)));
		return mv;
	}
	
	@PostMapping("/carros")
	public String salvar(Carro carro) {
		carroService.salvar(carro);
		return "redirect:/carros";
	}
	
	@GetMapping("/carros/{id}")
	public ModelAndView editar(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("EditaCarro");
		mv.addObject(carroService.procurar(id));
		return mv;
	}
	
	@GetMapping("/carros/deletar/{id}")
	public String excluir(@PathVariable("id") Long id) {
		carroService.deletar(id);
		return "redirect:/carros";
	}
	
	@GetMapping("/carros/deletar/confirmacao/{id}")
	public ModelAndView excluirPorOutraPagina(@PathVariable("id") Long id) {
		ModelAndView mv = new ModelAndView("ExcluirCarro");
		mv.addObject(carroService.procurar(id));
		return mv;
	}
	
	@DeleteMapping("/carros/deletar/{id}")
	public String excluirPorOutraPagina2(@PathVariable("id") Long id) {
		carroService.deletar(id);
		return "redirect:/carros";
	}
	
	@GetMapping("/")
	public String principal() {
		return "redirect:/carros";
	}
}
