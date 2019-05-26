package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class AcessorioDAO implements Serializable {

	private static final long serialVersionUID = 4914090865144131639L;
	
	@Inject
	private EntityManager em;
	
	public void salvar(Acessorio acessorio) {
		em.merge(acessorio);
	}
	
	public Acessorio buscarPeloCodigo(Long codigo) {
		return em.find(Acessorio.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Acessorio> buscarTodos() {
		return em.createQuery("from Acessorio").getResultList();
	}
	
	@Transactional
	public void excluir(Acessorio fabricante) throws NegocioException {
		fabricante = buscarPeloCodigo(fabricante.getCodigo());
		try {
			em.remove(fabricante);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("O Acessório Não Pode Ser Excluído!");
		}
	}
}
