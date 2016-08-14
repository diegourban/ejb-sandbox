package br.com.ejb.sandbox.agendador;

import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class Agendador {
	/*
	 * O agendador poderia ser um ejb-project separado contendo somente ele.
	 * Então geraria-se um ear project selecionado o projeto livraria war + agendador
	 * EAR encapsula os subprojetos
	 */

	/*
	 * Todo agendamento é persistido automaticamente. É obrigação do container
	 * EJB recuperar um agendamento caso o servidor tenha caído, por isso ele
	 * grava suas configurações. Podemos desabilitar isso através do atributo
	 * persistent=false
	 */

	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
	public void agendado() {
		System.out.println("verificando serviço externo periodicamente");
	}
}
