package com.algaworks.curso.jpa2.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("motorista")
public class Motorista extends Pessoa {

	private static final long serialVersionUID = -6240901006537040401L;

	private String cnh;

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	
}
