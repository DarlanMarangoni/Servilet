package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String paramLogin = request.getParameter("login");
		String paramSenha = request.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario usuario = banco.existe(paramLogin, paramSenha);
		
		if(usuario != null) {
			return "redirect:entrada?acao=ListaEmpresas";
		}else {
			System.out.println("Usuario "+ paramLogin + " nao cadastrado!");
			return "redirect:entrada?acao=formLogin";
		}
		
		
		
	}

}
