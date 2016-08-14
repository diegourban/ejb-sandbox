package br.com.ejb.sandbox.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import br.com.ejb.sandbox.dao.AutorDao;
import br.com.ejb.sandbox.modelo.Autor;

@Stateless
public class AutorService {
	
	@Inject
	private AutorDao dao;
	
	public void adiciona(Autor autor) {
		dao.salva(autor);
	}

	public List<Autor> todosAutores() {
		return dao.todosAutores();
	}

}
