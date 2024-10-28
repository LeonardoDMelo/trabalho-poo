package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class Pagamento extends BaseEntity {
	private static Integer serialId = 0;

	private Pessoa pessoa;
	private LocalDate data;
	private String descricao;
	private Fornecedor fornecedor;
	private Double valor;
	private Integer parcelas;

	public Pagamento(
		Pessoa pessoa,
		LocalDate data,
		String descricao,
		Fornecedor fornecedor,
		Double valor,
		Integer parcelas) {

		super();
		this.id = Pagamento.serialId++;

		this.pessoa = pessoa;
		this.data = data;
		this.descricao = descricao;
		this.fornecedor = fornecedor;
		this.valor = valor;
		this.parcelas = parcelas;
	}

	public Pagamento(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao,
		Pessoa pessoa,
		LocalDate data,
		String descricao,
		Fornecedor fornecedor,
		Double valor,
		Integer parcelas) {

		super(dataCriacao, dataModificacao);
		this.id = Pagamento.serialId++;

		this.pessoa = pessoa;
		this.data = data;
		this.descricao = descricao;
		this.fornecedor = fornecedor;
		this.valor = valor;
		this.parcelas = parcelas;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((fornecedor == null) ? 0 : fornecedor.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
		result = prime * result + ((parcelas == null) ? 0 : parcelas.hashCode());
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
		Pagamento other = (Pagamento) obj;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (fornecedor == null) {
			if (other.fornecedor != null)
				return false;
		} else if (!fornecedor.equals(other.fornecedor))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		if (parcelas == null) {
			if (other.parcelas != null)
				return false;
		} else if (!parcelas.equals(other.parcelas))
			return false;
		return true;
	}
}
