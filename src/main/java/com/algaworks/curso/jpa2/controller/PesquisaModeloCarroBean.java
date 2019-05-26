package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
@ManagedBean
public class PesquisaModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 283335660479064976L;

	private List<ModeloCarro> modelosCarro;
	private ModeloCarro modeloCarroSelecionado;
	@Inject
	private ModeloCarroDAO modeloCarroDAO;
	
	public List<ModeloCarro> getModelosCarro(){
		return modelosCarro;
	}

	@PostConstruct
	public void inicializar() {
		this.modelosCarro = modeloCarroDAO.buscarTodos();
	}

	public void excluir() {
		try {
			modeloCarroDAO.excluir(modeloCarroSelecionado);
			this.modelosCarro.remove(modeloCarroSelecionado);
			FacesUtil.addSuccessMessage("Modelo " + modeloCarroSelecionado.getDescricao() + "excluído com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
	}

	public ModeloCarro getModeloCarroSelecionado() {
		return modeloCarroSelecionado;
	}

	public void setModeloCarroSelecionado(ModeloCarro modeloCarroSelecionado) {
		this.modeloCarroSelecionado = modeloCarroSelecionado;
	}
}
