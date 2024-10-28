package main.java.com.codelinetrouble.casaja.enums;

public enum EstadoPagamento {
	PAGO(0, "pago"),
	EM_PAGAMENTO(1, "em pagamento");

	private final Integer codigo;
	private final String descricao;

	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static EstadoPagamento toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (EstadoPagamento estado: EstadoPagamento.values()) {
			if (estado.getCodigo().equals(codigo)) {
				return estado;
			}
		}

		throw new IllegalAccessError(String.format("EstadoPagamento com codigo %s inválido", codigo.toString()));
	}
}
