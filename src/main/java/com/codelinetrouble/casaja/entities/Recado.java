package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class Recado extends BaseEntity {
	private static Integer serialId = 0;

	private Pessoa pessoa;
	private String comentario;

	public Recado(
		Pessoa pessoa,
		String comentario) {

		super();
		this.id = Recado.serialId++;

		this.pessoa = pessoa;
		this.comentario = comentario;
	}

	public Recado(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao,
		Pessoa pessoa,
		String comentario) {

		super(dataCriacao, dataModificacao);
		this.id = Recado.serialId++;

		this.pessoa = pessoa;
		this.comentario = comentario;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
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
		Recado other = (Recado) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		return true;
	}
}
