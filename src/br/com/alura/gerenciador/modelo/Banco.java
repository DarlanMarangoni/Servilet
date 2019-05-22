package br.com.alura.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaDeUsuario = new ArrayList<>();
	private static Integer id = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Alura");
		empresa.setId(Banco.id++);
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Caelum");
		empresa2.setId(Banco.id++);
		
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario u1 = new Usuario();
		u1.setLogin("Leo");
		u1.setSenha("123");
		
		Usuario u2 = new Usuario();
		u2.setLogin("Vanessa");
		u2.setSenha("321");
		
		listaDeUsuario.add(u1);
		listaDeUsuario.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(id);
		lista.add(empresa);
		Banco.id++;
	}
	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}
	
	public void remove(int id) {
		Iterator<Empresa> it = lista.iterator();
		//utilizando iterator por que arraylist nao deixar remover 
		//o elemento que esta sendo  iterado
		while(it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}
	
	public Empresa buscar(int id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existe(String login, String senha) {
		for (Usuario usuario : listaDeUsuario) {
			if (usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
}
