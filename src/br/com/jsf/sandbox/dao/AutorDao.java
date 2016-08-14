package br.com.jsf.sandbox.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.jsf.sandbox.exception.LivrariaException;
import br.com.jsf.sandbox.interceptador.LogInterceptador;
import br.com.jsf.sandbox.modelo.Autor;

@Stateless
// @TransactionManagement(TransactionManagementType.BEAN) // por padrão é
// CONTAINER, caso queira que o bean gerencie a transação, use BEAN
@Interceptors({LogInterceptador.class})
public class AutorDao {

	@PersistenceContext
	private EntityManager entityManager;

	//@Inject
	//UserTransaction tx; // para gerenciar programaticamente pelo bean

	@PostConstruct
	void aposCriacao() {
		System.out.println("[INFO] AutorDao foi criado.");
	}

	@TransactionAttribute(TransactionAttributeType.MANDATORY)
	public void salva(Autor autor) {
		// 20 segundos para simular a criação de outro ejb quando esse estriver
		// sendo usado
		// try {
		// Thread.sleep(20000); // 20 segundos
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		
		// tx.begin(); // quando o transaction manager é o bean
		entityManager.persist(autor);
		// tx.commit(); // quando o transaction manager é o bean
		throw new LivrariaException();
	}

	public List<Autor> todosAutores() {
		return entityManager.createQuery("select a from Autor a", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.entityManager.find(Autor.class, autorId);
		return autor;
	}

}
