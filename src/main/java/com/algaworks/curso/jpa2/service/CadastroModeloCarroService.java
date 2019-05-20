package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroModeloCarroService implements Serializable {

	private static final long serialVersionUID = -7572737315143067085L;

	@Inject
	ModeloCarroDAO modeloCarroDAO;

	@Transactional
	public void salvar(ModeloCarro modeloCarro) throws NegocioException {
		if (modeloCarro.getDescricao() == null || modeloCarro.getDescricao().trim().equals("")) {
			throw new NegocioException("O Modelo do Carro é Obrigatório.");
		} else if (modeloCarro.getFabricante() == null) {
			throw new NegocioException("O Fabricante é Obrigatório.");
		}
		this.modeloCarroDAO.salvar(modeloCarro);
	}
}
