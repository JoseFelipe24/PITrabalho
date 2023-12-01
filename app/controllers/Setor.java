package controllers;

import java.util.List;

import Interface.Administrador;
import models.Bibliotecarios;
import models.Setores;
import play.data.validation.Valid;
import play.db.jpa.JPABase;
import play.mvc.Controller;
import play.mvc.With;

@Administrador
@With(Seguranca.class)
public class Setor extends Controller {

	
	public static void listar (String termo) {
		List<Setores> set = null;
		if (termo == null || termo.isEmpty()) {
			set = Setores.findAll();
		} else {
			set = Setores.find("lower(nome) like ?1 ",
					"%"+ termo.toLowerCase() +"%").fetch();
		}
		List<Bibliotecarios> bibliotecarios2 = Bibliotecarios.findAll();
		 render(set, termo,bibliotecarios2);
	}
	
	public static void remover (long id) {
		Setores s = Setores.findById(id);
		s.delete();
		listar("");
	}
	
	public static void salvar (@Valid Setores s, Long idBibliotecario) {
		
		if(validation.hasErrors()) {
			validation.keep();
			form();
		}
		
		else if (idBibliotecario != null) {
		  Bibliotecarios b = Bibliotecarios.findById(idBibliotecario);
		 s.bibliotecariolista.add(b);
		}
		
		s.save();
		editar(s.id);
		listar("");
	}
	
	public static void form () {
		
		render();
	}
	
	public static void editar (long id) {
		Setores s = Setores.findById(id);
		List<Bibliotecarios> bibliotecarios1 = Bibliotecarios.findAll();
		renderTemplate("Setor/form.html", s,bibliotecarios1);
		
	}
	
	public static void removerFuncionario(Long idSetor, Long idFuncio) {
		
		Setores s = Setores.findById(idSetor);
		Bibliotecarios b = Bibliotecarios.findById(idFuncio);
		s.bibliotecariolista.remove(b);
		
		s.save();
		listar(null);
	}
}
