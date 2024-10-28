package main.java.com.codelinetrouble.casaja.entities;

import java.time.LocalDateTime;
import java.time.LocalDate;

import main.java.com.codelinetrouble.casaja.entities.abstracts.BaseEntity;

public class Evento extends BaseEntity {
	private static Integer serialId = 0;

	private LocalDate data;
	private Cerimonial cerimonial;
	private Igreja igreja;
	private Cartorio cartorio;
	private Pessoa noiva;
	private Pessoa noivo;

	public Evento(
		LocalDate data,
		Cerimonial cerimonial,
		Igreja igreja,
		Cartorio cartorio,
		Pessoa noiva,
		Pessoa noivo) {

		super();
		this.id = Evento.serialId++;

		this.data = data;
		this.cerimonial = cerimonial;
		this.igreja = igreja;
		this.cartorio = cartorio;
		this.noiva = noiva;
		this.noivo = noivo;
	}

	public Evento(
		LocalDateTime dataCriacao,
		LocalDateTime dataModificacao,
		LocalDate data,
		Cerimonial cerimonial,
		Igreja igreja,
		Cartorio cartorio,
		Pessoa noiva,
		Pessoa noivo) {

		super(dataCriacao, dataModificacao);
		this.id = Evento.serialId++;

		this.data = data;
		this.cerimonial = cerimonial;
		this.igreja = igreja;
		this.cartorio = cartorio;
		this.noiva = noiva;
		this.noivo = noivo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Cerimonial getCerimonial() {
		return cerimonial;
	}

	public void setCerimonial(Cerimonial cerimonial) {
		this.cerimonial = cerimonial;
	}

	public Igreja getIgreja() {
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

	public Pessoa getNoiva() {
		return noiva;
	}

	public void setNoiva(Pessoa noiva) {
		this.noiva = noiva;
	}

	public Pessoa getNoivo() {
		return noivo;
	}

	public void setNoivo(Pessoa noivo) {
		this.noivo = noivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((cerimonial == null) ? 0 : cerimonial.hashCode());
		result = prime * result + ((igreja == null) ? 0 : igreja.hashCode());
		result = prime * result + ((cartorio == null) ? 0 : cartorio.hashCode());
		result = prime * result + ((noiva == null) ? 0 : noiva.hashCode());
		result = prime * result + ((noivo == null) ? 0 : noivo.hashCode());
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
		Evento other = (Evento) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (cerimonial == null) {
			if (other.cerimonial != null)
				return false;
		} else if (!cerimonial.equals(other.cerimonial))
			return false;
		if (igreja == null) {
			if (other.igreja != null)
				return false;
		} else if (!igreja.equals(other.igreja))
			return false;
		if (cartorio == null) {
			if (other.cartorio != null)
				return false;
		} else if (!cartorio.equals(other.cartorio))
			return false;
		if (noiva == null) {
			if (other.noiva != null)
				return false;
		} else if (!noiva.equals(other.noiva))
			return false;
		if (noivo == null) {
			if (other.noivo != null)
				return false;
		} else if (!noivo.equals(other.noivo))
			return false;
		return true;
	}
}
