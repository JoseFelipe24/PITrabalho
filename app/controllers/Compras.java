package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Bibliotecarios;
import models.Compra;
import models.Livro;
import play.cache.Cache;
import play.mvc.Controller;

public class Compras extends Controller {

	public static void PaginaInicial() {
		List<Livro> livrinhos = Livro.findAll();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livrinhos, itensCarrinho);
	}
	public static void Novidades() {
	
		List<Livro> livri1 = Livro.find("genero = ? 1 ", "romance").first();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livri1, itensCarrinho);
	}
	public static void Terror() {
		List<Livro> livri2 = Livro.find("genero = ? 1 ", "terror").first();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livri2, itensCarrinho);
	}
	public static void Romance() {
		List<Livro> livri3 = Livro.find("genero = ? 1 ", "romance").first();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livri3, itensCarrinho);
	}
	public static void Suspense() {
		List<Livro> livri4 = Livro.find("genero = ? 1 ", "suspense").first();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livri4, itensCarrinho);
	}
	public static void Fantasia() {
		List<Livro> livri5 = Livro.find("genero = ? 1 ", "fantasia").first();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livri5, itensCarrinho);
	}
	public static void lgbt() {
		List<Livro> livri6 = Livro.find("genero = ? 1 ", "RomanceLGBT").first();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		
		render(livri6, itensCarrinho);
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
		PaginaInicial();
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
	
}
