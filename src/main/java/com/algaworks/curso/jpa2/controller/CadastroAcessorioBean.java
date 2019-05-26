package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.service.CadastroAcessorioService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
@ManagedBean
public class CadastroAcessorioBean implements Serializable {

	private static final long serialVersionUID = -6050080846733117273L;

	private Acessorio acessorio;
	@Inject
	private CadastroAcessorioService cadastroAcessorioService;

	public void salvar() {
		try {
			this.cadastroAcessorioService.salvar(acessorio);
			FacesUtil.addSuccessMessage("Acessório Cadastrado com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}

	@PostConstruct
	public void init() {
		this.limpar();
	}

	public void limpar() {
		acessorio = new Acessorio();
	}

	public Acessorio getAcessorio() {
		return acessorio;
	}

	public void setAcessorio(Acessorio acessorio) {
		this.acessorio = acessorio;
	}
}
