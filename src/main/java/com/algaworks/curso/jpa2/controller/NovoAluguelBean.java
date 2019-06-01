package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.model.Aluguel;
import com.algaworks.curso.jpa2.model.ApoliceSeguro;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.service.CadastroAluguelService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
@ManagedBean
public class NovoAluguelBean implements Serializable {

	private static final long serialVersionUID = 3792899907770554789L;

	private Aluguel aluguel;
	private List<Carro> carros;
	@Inject
	private CadastroAluguelService cadastroAluguelService;
	@Inject
	private CarroDAO carroDAO;

	public void salvar() {
		try {
			this.cadastroAluguelService.salvar(aluguel);
			FacesUtil.addSuccessMessage("Aluguel Salvo com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.carros = carroDAO.buscarTodos();
	}

	private void limpar() {
		this.aluguel = new Aluguel();
		this.aluguel.setApoliceSeguro(new ApoliceSeguro());
	}

	public Aluguel getAluguel() {
		return aluguel;
	}

	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}

	public List<Carro> getCarros() {
		return carros;
	}
}
