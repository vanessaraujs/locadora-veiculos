package com.curso.jpa2.dao;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.curso.jpa2.model.Fabricante;

public class FabricanteDAO implements Serializable{

	private static final long serialVersionUID = 8184075695598257128L;
	
	EntityManager em;
	
	@Inject
	public void salvar(Fabricante fabricante) {
		em.persist(fabricante);
	}
}
