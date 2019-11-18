package br.edu.ifms.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ProjetoN1.model.Carro;
import br.edu.ifms.ProjetoN1.model.Multa;
import br.edu.ifms.ProjetoN1.repository.Carros;

@Service
public class CarroService {
	@Autowired
	private Carros carros;
	
	public List<Carro> buscarTodos(){
		return carros.findAll();
	}
	
	public void salvar(Carro carro) {
		carros.save(carro);
	}
	
	public Carro procurar(long id) {
		return carros.getOne(id);
	}
	
	public void deletar(long id) {
		carros.deleteById(id);
	}
	
	public int calculaTotalPontos(Carro carro) {
		int pontos = 0;
		
		for(Multa multa : carro.getMultas()) {
			pontos += multa.getTipoInfracao().getPontos();
		}
		
		return pontos;
	}
	
	public double calculaValorTotal(Carro carro) {
		double valor = 0;
		
		for(Multa multa : carro.getMultas()) {
			valor += multa.getTipoInfracao().getValor();
		}
		
		return valor;
	}
}
