package controllers;

import models.Bibliotecarios;
import play.mvc.Controller;

public class Login extends Controller {

	public static void loginn() {
		render();
	}
	
	public static void logar(String email, String senha) {
		
		Bibliotecarios bibli = Bibliotecarios.find("email = ? 1 and senha = ?2", email, senha).first();
		
		if (bibli == null) {
			loginn();
		}
		else {
			session.put("Bibliotecarios.funcao", bibli.funcao);
			session.put("Bibliotecarios.email", bibli.email);
	
			
			Setor.form();
		}
		
	}
	public static void sair() {
		session.clear();
		loginn();
	}
}
