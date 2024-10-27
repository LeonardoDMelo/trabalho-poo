package main.java.com.codelinetrouble.casaja.services.interfaces;

import java.util.List;

public interface ICrudService<D, I> {
	Boolean create(D dto);
	Integer create(List<D> dtos);
	D find(I id);
	List<D> find(List<I> ids);
	List<D> find();
	Boolean remove(I id);
	Integer remove(List<I> ids);
	Boolean update(D dto, I id);
}
