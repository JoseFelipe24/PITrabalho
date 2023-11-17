package controllers;

import java.util.List;

import Interface.Administrador;
import models.Livro;
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
	
	public static void remover (long id) {
		Livro l = Livro.findById(id);
		l.delete();
		listar("");
	}
	
	public static void salvar (Livro ll) {
		ll.save();
		listar("");
	}
	
	public static void form () {
		render();
	}
	
	public static void editar (long id) {
		Livro l = Livro.findById(id);
		renderTemplate("Livros/form.html", l);
		
	}	
	
}
