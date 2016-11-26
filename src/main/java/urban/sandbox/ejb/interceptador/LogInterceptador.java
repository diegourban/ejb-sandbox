package urban.sandbox.ejb.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {

	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		long millis = System.currentTimeMillis();

		// chamada do método do dao
		Object o = context.proceed();

		String nomeClasse = context.getTarget().getClass().getSimpleName();
        String nomeMetodo = context.getMethod().getName();
        System.out.println("[INFO] " + nomeClasse + "->" + nomeMetodo);
		System.out.println("[INFO] Tempo gasto no acesso ao BD: "
                + (System.currentTimeMillis() - millis) + "ms");

		return o;
	}

}
