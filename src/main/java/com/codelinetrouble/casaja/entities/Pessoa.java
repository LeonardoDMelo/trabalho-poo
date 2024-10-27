package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDate;

public class Pessoa extends BaseEntity {
	private static Integer serialId = 0;

	private Integer id;
	private String nome;
	private LocalDate nascimento;
	private String telefone;

	public Pessoa(String nome, LocalDate nascimento, String telefone) {
		super();
		this.id = Pessoa.serialId++;
		
		this.nome = nome;
		this.nascimento = nascimento;
		this.telefone = telefone;
	}

	public Pessoa(LocalDate dataCriacao, LocalDate dataModificacao, String nome, LocalDate nascimento, String telefone) {
		super(dataCriacao, dataModificacao);
		this.id = Pessoa.serialId++;
		
		this.nome = nome;
		this.nascimento = nascimento;
		this.telefone = telefone;
	}

	public Integer getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((nascimento == null) ? 0 : nascimento.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Pessoa other = (Pessoa) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (nascimento == null) {
			if (other.nascimento != null)
				return false;
		} else if (!nascimento.equals(other.nascimento))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}
}
