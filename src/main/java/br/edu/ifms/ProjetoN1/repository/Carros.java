package br.edu.ifms.ProjetoN1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifms.ProjetoN1.model.Carro;

public interface Carros extends JpaRepository<Carro, Long> {
	Carro findByPlaca(String placa);
}
