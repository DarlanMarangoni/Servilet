package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String valor = request.getHeader("accept");
		
		List<Empresa> empresas = new Banco().getEmpresas();
		
		if(valor.contains("xml")) {
			XStream xStream = new XStream();
			xStream.alias("empresa", Empresa.class);
			String xml = xStream.toXML(empresas);
			
			response.setContentType("application/xml");
			response.getWriter().println(xml);
			
		}else if (valor.contains("json")) {
			Gson gson = new Gson();
			String json = gson.toJson(empresas);
			
			response.setContentType("application/json");
			response.getWriter().println(json);
		}else {
			response.setContentType("application/json");
			response.getWriter().println("{'message':'no content'}");
		}
		
		
		
		
	}


}
