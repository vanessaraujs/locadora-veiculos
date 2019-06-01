package com.algaworks.curso.jpa2.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApoliceSeguro implements Serializable {

	private static final long serialVersionUID = 7736242923129382573L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private BigDecimal valorFranquia;
	private Boolean protecaoTerceiro;
	private Boolean protecaoCausasNaturais;
	private Boolean protecaoRoubo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getValorFranquia() {
		return valorFranquia;
	}

	public void setValorFranquia(BigDecimal valorFranquia) {
		this.valorFranquia = valorFranquia;
	}

	public Boolean getProtecaoTerceiro() {
		return protecaoTerceiro;
	}

	public void setProtecaoTerceiro(Boolean protecaoTerceiro) {
		this.protecaoTerceiro = protecaoTerceiro;
	}

	public Boolean getProtecaoCausasNaturais() {
		return protecaoCausasNaturais;
	}

	public void setProtecaoCausasNaturais(Boolean protecaoCausasNaturais) {
		this.protecaoCausasNaturais = protecaoCausasNaturais;
	}

	public Boolean getProtecaoRoubo() {
		return protecaoRoubo;
	}

	public void setProtecaoRoubo(Boolean protecaoRoubo) {
		this.protecaoRoubo = protecaoRoubo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ApoliceSeguro other = (ApoliceSeguro) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}
}
