package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;
import main.java.com.codelinetrouble.casaja.enums.TipoUsuario;

public class Usuario extends BaseEntity {
	private static Integer serialId = 0;

	private Pessoa pessoa;
	private TipoUsuario tipo;
	private String login;
	private String senha;

	public Usuario(
		Pessoa pessoa,
		TipoUsuario tipo,
		String login,
		String senha) {

		super();
		this.id = Usuario.serialId++;

		this.pessoa = pessoa;
		this.tipo = tipo;
		this.login = login;
		this.senha = senha;
	}

	public Usuario(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao,
		Pessoa pessoa,
		Integer tipo,
		String login,
		String senha) {

		super(dataCriacao, dataModificacao);
		this.id = Usuario.serialId++;

		this.pessoa = pessoa;
		this.tipo = TipoUsuario.toEnum(tipo);
		this.login = login;
		this.senha = senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (tipo != other.tipo)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
}
