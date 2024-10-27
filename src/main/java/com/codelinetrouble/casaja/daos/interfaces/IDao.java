package main.java.com.codelinetrouble.casaja.daos.interfaces;

import java.util.List;

public interface IDao<T, I> {
	Integer create(T entity);
	Integer create(List<T> entities);
	T find(I id);
	List<T> find(List<I> ids);
	List<T> find();
	Integer remove(I id);
	Integer remove(List<I> ids);
	Integer update(T entity, I id);
}
