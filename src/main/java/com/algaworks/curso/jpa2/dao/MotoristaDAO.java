package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.curso.jpa2.model.Motorista;
import com.algaworks.curso.jpa2.service.NegocioException;

public class MotoristaDAO implements Serializable {

	private static final long serialVersionUID = 7127723735024583850L;
	
	@Inject
	private EntityManager em;

	public Motorista buscarPeloCodigo(Long codigo) {
		return em.find(Motorista.class, codigo);
	}

	public void salvar(Motorista motorista) {
		em.merge(motorista);
	}

	public void excluir(Motorista motorista) throws NegocioException {
		motorista = em.find(Motorista.class, motorista.getCodigo());
		try {
			em.remove(motorista);
			em.flush();
		} catch (Exception e) {
			throw new NegocioException("Motorista Não Pode Ser Excluído!");
		}

	}
	
	@SuppressWarnings("unchecked")
	public List<Motorista> buscarTodos(){
		return em.createQuery("from Motorista").getResultList();
	}

}
