package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.model.Aluguel;

public class AluguelDAO implements Serializable {

	private static final long serialVersionUID = 1575072060543949621L;

	@Inject
	private EntityManager em;

	public Aluguel buscarPeloCodigo(Long codigo) {
		return em.find(Aluguel.class, codigo);
	}

	public void salvar(Aluguel aluguel) {
		em.merge(aluguel);
	}
}
