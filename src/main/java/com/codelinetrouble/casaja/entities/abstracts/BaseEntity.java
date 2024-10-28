package main.java.com.codelinetrouble.casaja.entities.abstracts;

import java.time.LocalDateTime;

public abstract class BaseEntity {
	protected Integer id;
	protected LocalDateTime dataCriacao;
	protected LocalDateTime dataModificacao;

	protected BaseEntity() {
		this.dataCriacao = LocalDateTime.now();
		this.dataModificacao = LocalDateTime.now();
	}

	protected BaseEntity(LocalDateTime dataCriacao, LocalDateTime dataModificacao) {
		if (dataCriacao == null) {
			this.dataCriacao = LocalDateTime.now();
		} else {
			this.dataCriacao = dataCriacao;
		}

		if(dataModificacao == null) {
			this.dataModificacao = LocalDateTime.now();
		} else {
			this.dataModificacao = dataModificacao;
		}
	}

	public Integer getId() {
		return id;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public LocalDateTime getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(LocalDateTime dataModificacao) {
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
