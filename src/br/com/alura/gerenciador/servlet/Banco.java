package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
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
	
}
