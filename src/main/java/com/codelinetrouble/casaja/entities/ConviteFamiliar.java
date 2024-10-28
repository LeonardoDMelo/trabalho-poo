package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class ConviteFamilia extends BaseEntity {
	private static Integer serialId = 0;

	private Pessoa pessoa;
	private String familia;
	private String acesso;

	public ConviteFamilia(
		Pessoa pessoa,
		String familia,
		String acesso) {

		super();
		this.id = ConviteFamilia.serialId++;

		this.pessoa = pessoa;
		this.familia = familia;
		this.acesso = acesso;
	}

	public ConviteFamilia(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao,
		Pessoa pessoa,
		String familia,
		String acesso) {

		super(dataCriacao, dataModificacao);
		this.id = ConviteFamilia.serialId++;

		this.pessoa = pessoa;
		this.familia = familia;
		this.acesso = acesso;
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

	public String getAcesso() {
		return acesso;
	}

	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((familia == null) ? 0 : familia.hashCode());
		result = prime * result + ((acesso == null) ? 0 : acesso.hashCode());
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
		ConviteFamilia other = (ConviteFamilia) obj;
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
		if (acesso == null) {
			if (other.acesso != null)
				return false;
		} else if (!acesso.equals(other.acesso))
			return false;
		return true;
	}
}
