package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.AluguelDAO;
import com.algaworks.curso.jpa2.model.Aluguel;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroAluguelService implements Serializable {

	private static final long serialVersionUID = -1052949654200302486L;

	@Inject
	private AluguelDAO aluguelDAO;

	@Transactional
	public void salvar(Aluguel aluguel) throws NegocioException {

		if (aluguel.getCarro() == null) {
			throw new NegocioException("O Carro é Obrigatório!");
		}

		this.aluguelDAO.salvar(aluguel);
	}

}
