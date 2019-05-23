package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@WebFilter(urlPatterns="/entrada") //mapeado com a mesma anotacao da servlet para ser chamada junto, porem filter e executado 1º e ultimo
public class MonitoramentoFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("monitoramento");
		
		long antes = System.currentTimeMillis();
		//filter funciona igual o servlet, podemos utilizar os mesmos metodos
		String acao = request.getParameter("acao");
		
		//"vai " manda a requisicao para frente
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		//mostra o tempo de execucao
		System.out.println("tempo de execução: " + acao + "->" + (depois - antes));
		
	}

}
