package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import Interface.Administrador;
import models.Bibliotecarios;
import models.Cliente;
import models.Compra;
import models.Livro;
import play.cache.Cache;
import play.db.jpa.Blob;
import play.libs.MimeTypes;
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
		else if(validation.hasErrors()) {
			validation.keep();
			PaginaInicial();
		}
		Compra pedido = new Compra();
		pedido.livroslista =itensCarrinhoo ;
		
		  
		String email = session.get("Cliente.email");
		
		Cliente clienti = Cliente.find("email = ? 1", email).first();
		pedido.cliente =clienti;
		pedido.enderecoDeEntrega= clienti.endereco;
		pedido.save();
		Cache.clear();
		Clientes.detalhar();
	}
	
	public static void detalharCompra(Long id) {
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
	public static void capaLivro(Long id) {
		Livro livro = Livro.findById(id);
		notFoundIfNull(livro);
		response.setContentTypeIfNotSet(livro.Imagem.type());
		livro.save();
		renderBinary(livro.Imagem.get());
	}
	public static void nomecapaLivro(File foto) throws FileNotFoundException {
		Livro livro = new Livro();
		livro.nomeImagem=foto.getName();
		livro.Imagem = new Blob();
		livro.Imagem.set(new FileInputStream(foto), MimeTypes.getContentType(foto.getName()));
		livro.save();
		
	}
	public static void detalharLivro(Long id) {
		Livro livro = Livro.findById(id);
		render(livro);
	}

	public static void Novidades() {
		
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		String termo="terror";
		List<Livro> lili = Livro.find("lower(genero) like ?1 ","%"+ termo.toLowerCase() +"%").fetch();

		render(lili, itensCarrinho);
	}
	public static void Terror() {
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		String termo="terror";
		List<Livro> lili = Livro.find("lower(genero) like ?1 ","%"+ termo.toLowerCase() +"%").fetch();

		render(lili, itensCarrinho);
	}
	public static void Romance() {
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		String termo="Romance";
		List<Livro> lili = Livro.find("lower(genero) like ?1 ","%"+ termo.toLowerCase() +"%").fetch();

		render(lili, itensCarrinho);
	}
	public static void Suspense() {
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		String termo="Suspense";
		List<Livro> lili = Livro.find("lower(genero) like ?1 ","%"+ termo.toLowerCase() +"%").fetch();
		
		render(lili, itensCarrinho);
	}
	public static void Fantasia() {
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		String termo="Fantasia";
		List<Livro> lili = Livro.find("lower(genero) like ?1 ","%"+ termo.toLowerCase() +"%").fetch();

		render(lili, itensCarrinho);
	}
	public static void lgbt() {
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		String termo="LGBT";
		List<Livro> lili = Livro.find("lower(genero) like ?1 ","%"+ termo.toLowerCase() +"%").fetch();

		render(lili, itensCarrinho);
	}
}
