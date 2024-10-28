package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class Presente extends BaseEntity {
	private static Integer serialId = 0;

	private String nome;
	private String tipo;
	private Double valor;
	private Pessoa pessoa;

	public Presente(
		String nome,
		String tipo,
		Double valor,
		Pessoa pessoa) {

		super();
		this.id = Presente.serialId++;

		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.pessoa = pessoa;
	}

	public Presente(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao,
		String nome,
		String tipo,
		Double valor,
		Pessoa pessoa) {

		super(dataCriacao, dataModificacao);
		this.id = Presente.serialId++;

		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.pessoa = pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		Presente other = (Presente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}
}
