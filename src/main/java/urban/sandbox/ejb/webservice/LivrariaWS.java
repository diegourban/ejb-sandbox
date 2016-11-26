package urban.sandbox.ejb.webservice;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import urban.sandbox.ejb.dao.LivroDao;
import urban.sandbox.ejb.modelo.Livro;

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
