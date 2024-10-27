package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDate;

public abstract class BaseEntity {
	protected LocalDate dataCriacao;
	protected LocalDate dataModificacao;

	protected BaseEntity() {
		this.dataCriacao = LocalDate.now();
		this.dataModificacao = LocalDate.now();
	}

	protected BaseEntity(LocalDate dataCriacao, LocalDate dataModificacao) {
		if (dataCriacao == null) {
			this.dataCriacao = LocalDate.now();
		} else {
			this.dataCriacao = dataCriacao;
		}

		if(dataModificacao == null) {
			this.dataModificacao = LocalDate.now();
		} else {
			this.dataModificacao = dataModificacao;
		}
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDate getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(LocalDate dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataCriacao == null) ? 0 : dataCriacao.hashCode());
		result = prime * result + ((dataModificacao == null) ? 0 : dataModificacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		
		if (dataCriacao == null) {
			if (other.dataCriacao != null)
				return false;
		} else if (!dataCriacao.equals(other.dataCriacao))
			return false;
		if (dataModificacao == null) {
			if (other.dataModificacao != null)
				return false;
		} else if (!dataModificacao.equals(other.dataModificacao))
			return false;
		return true;
	}
}
