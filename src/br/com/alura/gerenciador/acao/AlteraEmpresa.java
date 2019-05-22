package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramNome = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("dataAbertura");
		String paramId = request.getParameter("id");
		
		Integer id = Integer.valueOf(paramId);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();

		Empresa empresa = banco.buscar(id);
		empresa.setNome(paramNome);
		empresa.setDataAbertura(dataAbertura);
		
		return "redirect:entrada?acao=listaEmpresa";
	}

}
