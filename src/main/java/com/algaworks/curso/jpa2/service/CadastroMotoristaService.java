package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.MotoristaDAO;
import com.algaworks.curso.jpa2.model.Motorista;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CadastroMotoristaService implements Serializable {

	private static final long serialVersionUID = -7482544990468466073L;
	
	@Inject
	private MotoristaDAO motoristaDAO;

	@Transactional
	public void salvar(Motorista motorista) throws NegocioException {
		this.motoristaDAO.salvar(motorista);
	}

}
