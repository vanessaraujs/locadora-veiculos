package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.FabricanteDAO;
import com.algaworks.curso.jpa2.model.Categoria;
import com.algaworks.curso.jpa2.model.Fabricante;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroModeloCarroService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;

@Named
@ViewScoped
@ManagedBean
public class CadastroModeloCarroBean implements Serializable {

	private static final long serialVersionUID = 85315315466450259L;

	private ModeloCarro modeloCarro;

	private List<Fabricante> fabricantes;
	
	private List<Categoria> categorias;
	
	@Inject
	private CadastroModeloCarroService cadastroModeloCarroService;

	@Inject
	private FabricanteDAO fabricanteDAO;

	public void salvar() {
		try {
			this.cadastroModeloCarroService.salvar(modeloCarro);
			FacesUtil.addSuccessMessage("Modelo Salvo com Sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		this.limpar();
	}

	@PostConstruct
	public void init() {
		this.limpar();
		this.fabricantes = fabricanteDAO.buscarTodos();
		this.categorias = Arrays.asList(Categoria.values());
	}

	public void limpar() {
		this.modeloCarro = new ModeloCarro();
	}

	public ModeloCarro getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(ModeloCarro modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

}
