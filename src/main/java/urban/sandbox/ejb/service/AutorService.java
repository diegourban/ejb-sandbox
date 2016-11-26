package urban.sandbox.ejb.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import urban.sandbox.ejb.dao.AutorDao;
import urban.sandbox.ejb.modelo.Autor;

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
