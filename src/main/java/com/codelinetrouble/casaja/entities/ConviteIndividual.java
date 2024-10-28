package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class ConviteIndividual extends BaseEntity {
	private static Integer serialId = 0;

	private Pessoa pessoa;
	private String familia;
	private String parentesco;
	private Boolean confirmacao;

	public ConviteIndividual(
		Pessoa pessoa,
		String familia,
		String parentesco,
		Boolean confirmacao) {

		super();
		this.id = ConviteIndividual.serialId++;

		this.pessoa = pessoa;
		this.familia = familia;
		this.parentesco = parentesco;
		this.confirmacao = confirmacao;
	}

	public ConviteIndividual(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao,
		Pessoa pessoa,
		String familia,
		String parentesco,
		Boolean confirmacao) {

		super(dataCriacao, dataModificacao);
		this.id = ConviteIndividual.serialId++;

		this.pessoa = pessoa;
		this.familia = familia;
		this.parentesco = parentesco;
		this.confirmacao = confirmacao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	public Boolean getConfirmacao() {
		return confirmacao;
	}

	public void setConfirmacao(Boolean confirmacao) {
		this.confirmacao = confirmacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result + ((parentesco == null) ? 0 : parentesco.hashCode());
		result = prime * result + ((confirmacao == null) ? 0 : confirmacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConviteIndividual other = (ConviteIndividual) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (familia == null) {
			if (other.familia != null)
				return false;
		} else if (!familia.equals(other.familia))
			return false;
		if (parentesco == null) {
			if (other.parentesco != null)
				return false;
		} else if (!parentesco.equals(other.parentesco))
			return false;
		if (confirmacao == null) {
			if (other.confirmacao != null)
				return false;
		} else if (!confirmacao.equals(other.confirmacao))
			return false;
		return true;
	}

}
