package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.model.Motorista;
import com.algaworks.curso.jpa2.model.Sexo;
import com.algaworks.curso.jpa2.service.CadastroMotoristaService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
@ManagedBean
public class CadastroMotoristaBean implements Serializable {

	private static final long serialVersionUID = 8838519128409049721L;

	private Motorista motorista;
	private List<Sexo> sexos;
	@Inject
	private CadastroMotoristaService cadastroMotoristaService;

	public void salvar() {
		try {
			this.cadastroMotoristaService.salvar(motorista);
			FacesUtil.addSuccessMessage("Motorista Salvo com Sucesso!");
			this.limpar();
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.sexos = Arrays.asList(Sexo.values());
	}

	public void limpar() {
		this.motorista = new Motorista();
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public List<Sexo> getSexos() {
		return sexos;
	}

}
