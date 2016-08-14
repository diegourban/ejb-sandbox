package br.com.jsf.sandbox.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.jsf.sandbox.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void salva(Livro livro) {
		entityManager.persist(livro);
	}

	public List<Livro> todosLivros() {
		return entityManager.createQuery("select l from Livro l", Livro.class).getResultList();
	}

	public List<Livro> livrosPeloNome(String nome) {
		TypedQuery<Livro> query = this.entityManager
				.createQuery("select l from Livro l " + "where l.titulo like :pTitulo", Livro.class);
		query.setParameter("pTitulo", "%" + nome + "%");

		return query.getResultList();
	}

}
