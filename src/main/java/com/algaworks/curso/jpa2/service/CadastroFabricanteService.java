package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.model.Fabricante;

public class CadastroFabricanteService implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private FabricanteDAO fabricanteDAO;
	
	public void salvar(Fabricante fabricante) throws NegocioException {
		if(fabricante.getNome() == null || fabricante.getNome().trim().equals("")) {
			throw new NegocioException("O nome do fabricante é obrigatório!");
		}
		this.fabricanteDAO.salvar(fabricante);
	}
}
