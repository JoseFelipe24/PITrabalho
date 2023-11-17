package controllers;

import Interface.Administrador;
import play.mvc.Before;
import play.mvc.Controller;

public class Seguranca extends Controller{

	@Before
	static void verificar() {
		/*o if vai verrificar se ele não tem a session,se não tiver ela é porque não fez login 
		 * e a tela não vai deixar ele acessar a pagina sem o login, mandando ele pro login
		*/
		if(session.contains("Bibliotecarios.email")== false) {
			Login.loginn();
		}
	}
	
	@Before
	static void VerificarADM() {
		String perfil = session.get("Bibliotecarios.funcao");
		Administrador adminAnnotation = getControllerAnnotation(Administrador.class);
		if(adminAnnotation != null && !"Administrador".equals(perfil)) {
			forbidden("Aceso restrito aos administradores do sistema");
		}
		
	}
}
