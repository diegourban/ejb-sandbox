package urban.sandbox.ejb.bean;

import java.util.List;

import javax.enterprise.inject.Model;
import javax.inject.Inject;

import urban.sandbox.ejb.modelo.Autor;
import urban.sandbox.ejb.service.AutorService;

@Model
public class AutorBean {
	
	private Autor autor = new Autor();
	
	@Inject
	private AutorService service;
	
	public Autor getAutor() {
		return autor;
	}
	
	public void cadastra() {
		this.service.adiciona(autor);
		this.autor = new Autor();
	}
	
	public List<Autor> getAutores() {
		return this.service.todosAutores();
	}
}
