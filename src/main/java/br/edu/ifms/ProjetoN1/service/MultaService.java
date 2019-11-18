package br.edu.ifms.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ProjetoN1.model.Multa;
import br.edu.ifms.ProjetoN1.repository.Carros;
import br.edu.ifms.ProjetoN1.repository.Multas;

@Service
public class MultaService {
	@Autowired
	private Multas multas;
	@Autowired
	private Carros carros;
	
	public void salvar(Multa multa) {
		multa.setCarro(carros.findByPlaca(multa.getCarro().getPlaca()));
		multas.save(multa);
	}
	
	public List<Multa> buscarTodos(){
		return multas.findAll();
	}
	
	public Multa procurar(long id) {
		return multas.getOne(id);
	}
	
	public void deletar(long id) {
		multas.deleteById(id);
	}
	
	
}
