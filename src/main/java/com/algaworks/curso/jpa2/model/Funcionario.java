package com.algaworks.curso.jpa2.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("funcionario")
public class Funcionario extends Pessoa {

	private static final long serialVersionUID = -5937825941498203523L;

}
