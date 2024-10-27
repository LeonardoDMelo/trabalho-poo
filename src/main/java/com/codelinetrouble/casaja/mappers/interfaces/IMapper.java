package main.java.com.codelinetrouble.casaja.mappers.interfaces;

public interface IMapper<E, D> {
	E mapToEntity(D dto);
	D mapToDto(E entity);
}
