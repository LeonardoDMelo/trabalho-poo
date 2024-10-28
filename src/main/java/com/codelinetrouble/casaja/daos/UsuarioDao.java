package main.java.com.codelinetrouble.casaja.daos;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import main.java.com.codelinetrouble.casaja.daos.interfaces.IDao;
import main.java.com.codelinetrouble.casaja.entities.Usuario;

public class UsuarioDao implements IDao<Usuario, Integer>{
	private List<Usuario> usuarios;

	public UsuarioDao() {
		this.usuarios = new ArrayList<>();
	}

	@Override
	public Integer create(Usuario entity) {
		Integer counter = 0;
		entity.setDataCriacao(LocalDateTime.now());
		
		if (usuarios.add(entity)) {
			counter++;
		}

		return counter;
	}

	@Override
	public Integer create(List<Usuario> entities) {
		Integer counter = 0;
		
		for(Usuario entity: entities) {
			entity.setDataCriacao(LocalDateTime.now());
			if (usuarios.add(entity)) {
				counter++;
			}
		}

		return counter;
	}

	@Override
	public Usuario find(Integer id) {
		for(Usuario usuario: usuarios) {
			if (usuario.getId().equals(id)) {
				return usuario;
			}
		}

		return null;
	}

	@Override
	public List<Usuario> find(List<Integer> ids) {
		List<Usuario> entities = new ArrayList<>();

		for(Usuario usuario: usuarios) {
			if (ids.contains(usuario.getId())) {
				ids.remove(usuario.getId());
				entities.add(usuario);
			}
		}

		return entities;
	}

	@Override
	public List<Usuario> find() {
		return usuarios;
	}

	@Override
	public Integer remove(Integer id) {
		Integer counter = 0;
		
		for(Usuario usuario: usuarios) {
			if (usuario.getId().equals(id)) {
				usuarios.remove(usuario);
				counter++;
				break;
			}
		}

		return counter;
	}

	@Override
	public Integer remove(List<Integer> ids) {
		Integer counter = 0;

		Iterator<Usuario> it = usuarios.iterator();
		while(it.hasNext()) {
			Usuario usuario = it.next();

			if (ids.contains(usuario.getId())) {
				ids.remove(usuario.getId());
				it.remove();

				counter++;
			}
		}

		return counter;
	}

	@Override
	public Integer update(Usuario entity, Integer id) {
		Integer counter = 0;
		entity.setDataModificacao(LocalDateTime.now());

		for(Usuario usuario: usuarios) {
			if (usuario.getId().equals(id)) {
				usuarios.remove(usuario);
				usuarios.add(entity);
				counter++;
				break;
			}
		}

		return counter;
	}
}
