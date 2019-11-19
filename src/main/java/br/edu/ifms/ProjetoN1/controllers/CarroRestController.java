package br.edu.ifms.ProjetoN1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.ProjetoN1.model.Carro;
import br.edu.ifms.ProjetoN1.service.CarroService;

@RestController
public class CarroRestController {
	
	@Autowired
	private CarroService carroService;
	
	@RequestMapping(value="/rest/carros", method = RequestMethod.POST)
	public void salvar(Carro carro){
		carroService.salvar(carro);
	}
	
	@RequestMapping(value="/rest/carros/{id}", method = RequestMethod.DELETE)
	public void remover(@PathVariable("id") Long id){
		carroService.deletar(id);
	}
	
	@RequestMapping(value="/rest/carros", method = RequestMethod.PUT)
	public void alterar(Carro carro){
		carroService.salvar(carro);
	}
	
	@RequestMapping(value="/rest/carros", method = RequestMethod.GET)
	public List<Carro> buscarTodos(){
		return carroService.buscarTodos();
	}

}