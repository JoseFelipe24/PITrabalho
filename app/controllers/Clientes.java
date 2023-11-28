package controllers;

import java.util.List;

import models.Bibliotecarios;
import models.Cliente;
import models.Compra;
import models.Livro;

import models.Setores;
import play.mvc.Controller;

public class Clientes extends Controller{

	public static void listar (String termo) {
		List<Cliente> cli = null;
		if (termo == null || termo.isEmpty()) {
			cli = Cliente.findAll();
		} else {
			cli = Cliente.find("lower(nome) like ?1 or lower(cpf) like ?1",
					"%"+ termo.toLowerCase() +"%").fetch();
		}
		 render(cli, termo);
		
	}
	
	public static void remover (long id) {
		Cliente c = Cliente.findById(id);
		c.delete();
		listar("");
	}
	
	public static void salvar (Cliente cc) {
		cc.save();
		Login.loginn2();
	}
	
	public static void form () {
		render();
	}
	
	public static void editar (long id) {
		Cliente c = Cliente.findById(id);
		renderTemplate("Livros/form.html", c);
		
	}	
	public static void CancelarCompra(Long idCliente, Long idCompra) {
		
		Cliente c = Cliente.findById(idCliente);
		Compra comp1 = Compra.findById(idCompra);
		
		c.listaCompras.remove(comp1);
		
		c.save();
		comp1.delete();
		
		listar(null);
	}
	
	public static void detalhar() {
		String email = session.get("Cliente.email");
		Cliente Clientinho = Cliente.find("email = ?1", email).first();
		
		List<Compras> comprinhas= Compra.find("ClienteDaCompra = ?1", Clientinho).first();
		

		render(Clientinho,comprinhas);
	}
	public static void PaginaCliente() {
		render();
	}
	
	
	
}
