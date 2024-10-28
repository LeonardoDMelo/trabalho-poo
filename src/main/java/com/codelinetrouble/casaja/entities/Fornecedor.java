package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;
import main.java.com.codelinetrouble.casaja.enums.EstadoPagamento;

public class Fornecedor extends BaseEntity {
	private static Integer serialId = 0;

	private String nome;
	private String cnpj;
	private String telefone;
	private Double valorAPagar;
	private Integer parcelas;
	private EstadoPagamento estado;

	public Fornecedor(
		String nome,
		String cnpj,
		String telefone,
		Double valorAPagar,
		Integer parcelas,
		EstadoPagamento estado) {

		super();
		this.id = Fornecedor.serialId++;
		
		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.valorAPagar = valorAPagar;
		this.parcelas = parcelas;
		this.estado = estado;
	}
	
	public Fornecedor(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao,
		String nome,
		String cnpj,
		String telefone,
		Double valorAPagar,
		Integer parcelas,
		Integer estado) {

		super(dataCriacao, dataModificacao);
		this.id = Fornecedor.serialId++;

		this.nome = nome;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.valorAPagar = valorAPagar;
		this.parcelas = parcelas;
		this.estado = EstadoPagamento.toEnum(estado);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getValorAPagar() {
		return valorAPagar;
	}

	public void setValorAPagar(Double valorAPagar) {
		this.valorAPagar = valorAPagar;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	public EstadoPagamento getEstado() {
		return estado;
	}

	public void setEstado(EstadoPagamento estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
		result = prime * result + ((valorAPagar == null) ? 0 : valorAPagar.hashCode());
		result = prime * result + ((parcelas == null) ? 0 : parcelas.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		if (valorAPagar == null) {
			if (other.valorAPagar != null)
				return false;
		} else if (!valorAPagar.equals(other.valorAPagar))
			return false;
		if (parcelas == null) {
			if (other.parcelas != null)
				return false;
		} else if (!parcelas.equals(other.parcelas))
			return false;
		return (estado == other.estado);
	}
}
