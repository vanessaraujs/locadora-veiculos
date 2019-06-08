package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
@ManagedBean
public class PesquisaCarroBean implements Serializable {

	private static final long serialVersionUID = -2105536617765488716L;

	@Inject
	private CarroDAO carroDAO;
	private List<Carro> carros = new ArrayList<>();
	private Carro carroSelecionado;

	@SuppressWarnings("unused")
	public List<Carro> getCarros() {
		return carros;
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

	public void excluir() {
		try {
			carroDAO.excluir(carroSelecionado);
			this.carros.remove(carroSelecionado);
			FacesUtil.addSuccessMessage("Carro " + carroSelecionado.getModeloCarro() + "Excluído com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		carros = carroDAO.buscarTodos();
	}

	public void buscarCarroComAcessorios() {
		carroSelecionado = carroDAO.buscarCarroComAcessorios(carroSelecionado.getCodigo());
	}

}
