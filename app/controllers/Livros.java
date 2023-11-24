package controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import Interface.Administrador;
import models.Cliente;
import models.Livro;
import play.cache.Cache;
import play.db.jpa.Blob;
import play.libs.MimeTypes;
import play.mvc.Controller;
import play.mvc.With;

@Administrador
@With(Seguranca.class)
public class Livros extends Controller{

	
	public static void listar (String termo) {
		List<Livro> lili = null;
		if (termo == null || termo.isEmpty()) {
			lili = Livro.findAll();
		} else {
			lili = Livro.find("lower(nome) like ?1 or lower(autor) like ?1",
					"%"+ termo.toLowerCase() +"%").fetch();
		}
		 render(lili, termo);
		
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
	
	public static void remover (long id) {
		Livro l = Livro.findById(id);
		l.delete();
		listar("");
	}
	
	
	public static void form () {
		render();
	}
	
	public static void editar (long id) {
		Livro l = Livro.findById(id);
		renderTemplate("Livros/form.html", l);
		
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
 
	public static void salvar (Livro ll) {
		
		ll.save();
		listar("");

	}
	public static void detalhar(Long id) {
		Livro livro = Livro.findById(id);
		render(livro);
	}
	
	public static void Novidades() {
		
		List<Livro> livri1 = Livro.find("genero = ? 1 ", "romance").first();
		List<Livro> itensCarrinho = Cache.get(session.getId(), List.class);
		render(livri1, itensCarrinho);
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
