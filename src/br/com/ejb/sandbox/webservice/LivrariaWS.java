package br.com.ejb.sandbox.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.ejb.sandbox.dao.LivroDao;
import br.com.ejb.sandbox.modelo.Livro;

@Stateless
@WebService
public class LivrariaWS {

	@Inject
	private LivroDao livroDao;

	@WebResult(name = "livros")
	public List<Livro> getLivrosPeloNome(@WebParam(name = "titulo") String nome) {
		System.out.println("LivrariaWS: procurando pelo nome " + nome);

		return livroDao.livrosPeloNome(nome);
	}

}