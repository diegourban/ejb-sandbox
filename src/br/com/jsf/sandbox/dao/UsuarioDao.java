package br.com.jsf.sandbox.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.jsf.sandbox.modelo.Usuario;

@Stateless
public class UsuarioDao {

	@PersistenceContext
	private EntityManager entityManager;

	public Usuario buscaPeloLogin(String login) {
		Usuario usuario = (Usuario) this.entityManager.createQuery("select u from Usuario u where u.login=:pLogin")
				.setParameter("pLogin", login).getSingleResult();
		return usuario;
	}

}
