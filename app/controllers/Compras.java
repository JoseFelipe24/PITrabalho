package controllers;

import java.util.ArrayList;
import java.util.List;

import Interface.Administrador;
import models.Bibliotecarios;
import models.Compra;
import models.Livro;
import play.cache.Cache;
import play.mvc.Before;
import play.mvc.Controller;


public class Compras extends Controller {

	@Before(only={"listar","carrinho","salvar","addLivro",})
	static void verificarr() {
		if(session.get("Cliente.email")== null) 
			Login.loginn2();
		
		}

	public static void PaginaInicial() {
		List<Livro> livrinhos = Livro.findAll();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livrinhos, itensCarrinho);
	}
	public static void carrinho() {
		List<Livro> livrinhos = Livro.findAll();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livrinhos, itensCarrinho);
	}
	
	
	public static void listar() {
		List<Compra> comprass = Compra.findAll();
		render(comprass);
	}
	
	public static void addLivro(Long id) {
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
	 	if (itensCarrinho == null) {
	 		itensCarrinho = new ArrayList<Livro>();
	 	}
	 	
	 	Livro livrocar = Livro.findById(id);
		itensCarrinho.add(livrocar);
		Cache.set(session.getId(), itensCarrinho);
		carrinho();
	}
	
	public static void salvar() {
		List<Livro> itensCarrinhoo = Cache.get(session.getId(), List.class);
		if (itensCarrinhoo == null) {
			PaginaInicial();
		}
		
		Compra pedido = new Compra();
		pedido.livroslista =itensCarrinhoo ;
		pedido.save();
		
		Cache.clear();
	}
	
	public static void detalhar(Long id) {
		Compra pedido = Compra.findById(id);
		render(pedido);
	}
	public static void listarCompras (String termo) {
		List<Livro> lili = null;
		if (termo == null || termo.isEmpty()) {
			lili = Livro.findAll();
		} else {
			lili = Livro.find("lower(nome) like ?1 or lower(autor) like ?1",
					"%"+ termo.toLowerCase() +"%").fetch();
		}
		 render(lili, termo);
		
	}
}
