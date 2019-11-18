package br.edu.ifms.ProjetoN1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifms.ProjetoN1.model.Infracao;
import br.edu.ifms.ProjetoN1.repository.Infracoes;

@Service
public class InfracaoService {
	@Autowired
	private Infracoes infracoes;
	
	public List<Infracao> buscarTodos(){
		return this.infracoes.findAll();
	}
	
	public void salvar(Infracao infracao) {
		infracoes.save(infracao);
	}
	
	public Infracao procurar(long id) {
		return infracoes.getOne(id);
	}
	
	public void deletar(long id) {
		infracoes.deleteById(id);
	}
}
