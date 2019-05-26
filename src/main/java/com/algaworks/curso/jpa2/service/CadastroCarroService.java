package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroCarroService implements Serializable {

	private static final long serialVersionUID = -8964271001640718675L;

	@Inject
	private CarroDAO carroDAO;

	@Transactional
	public void salvar(Carro carro) throws NegocioException {
		if (carro.getPlaca() == null || carro.getPlaca().trim().equals("")) {
			throw new NegocioException("A Placa do Carro é Obrigatória!");
		}
		this.carroDAO.salvar(carro);
	}

}
