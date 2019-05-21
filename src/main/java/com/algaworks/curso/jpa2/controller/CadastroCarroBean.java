package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.AcessorioDAO;
import com.algaworks.curso.jpa2.dao.ModeloCarroDAO;
import com.algaworks.curso.jpa2.model.Acessorio;
import com.algaworks.curso.jpa2.model.Carro;
import com.algaworks.curso.jpa2.model.ModeloCarro;
import com.algaworks.curso.jpa2.service.CadastroCarroService;

@Named
@ViewScoped
public class CadastroCarroBean implements Serializable {

	private static final long serialVersionUID = -4366066494336871300L;

	private Carro carro;
	private List<ModeloCarro> modeloCarros;
	private List<Acessorio> acessorios;
	@Inject
	private CadastroCarroService cadastroCarroService;
	@Inject
	private AcessorioDAO acessorioDAO;
	@Inject
	private ModeloCarroDAO modeloCarroDAO;
}
