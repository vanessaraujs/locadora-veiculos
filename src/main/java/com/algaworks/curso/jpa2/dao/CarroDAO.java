package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;

public class CarroDAO implements Serializable {

	private static final long serialVersionUID = -5901907408475648128L;

	@Inject
	private EntityManager em;

	public void salvar(Carro carro) {
		em.merge(carro);
	}

	public Carro buscarPeloCodigo(Long codigo) {
		return em.find(Carro.class, codigo);
	}

	@SuppressWarnings("unchecked")
	public List<Carro> buscarTodos() {
		return em.createQuery("from Carro").getResultList();
	}

	@Transactional
	public void excluir(Carro carro) throws NegocioException {
		carro = buscarPeloCodigo(carro.getCodigo());
		try {
			em.remove(carro);
			em.flush();
		} catch (PersistenceException e) {
			throw new NegocioException("Carro Não Pode Ser Excluído!");
		}
	}

	public Carro buscarCarroComAcessorios(Long codigo) {
		return null;
	}

}
