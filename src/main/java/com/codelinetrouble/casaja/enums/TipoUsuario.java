package main.java.com.codelinetrouble.casaja.enums;

public enum TipoUsuario {
	NOIVO(0, "noivo"),
	CERIMONIAL(1, "cerimonial");

	private final Integer codigo;
	private final String descricao;

	private TipoUsuario(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public static TipoUsuario toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}

		for (TipoUsuario estado: TipoUsuario.values()) {
			if (estado.getCodigo().equals(codigo)) {
				return estado;
			}
		}

		throw new IllegalAccessError(String.format("TipoUsuario com codigo %s inválido", codigo.toString()));
	}
}
