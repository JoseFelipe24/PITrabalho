package models;

import java.util.List;

import javax.persistence.Entity;
import play.db.jpa.Model;
import play.libs.Crypto;



@Entity
public class Bibliotecarios extends Model {
	
	public String nome;
	public long cpf;
	public String email;
	public String senha;
	public String funcao;

	
//	public void setSenha(String senha) {
		//vai criptografar a senha antes dela entrar no banco de dados
		//evitando que usuarios que tenha acesso a o BD possam ver as senhas de todos
//		senha = Crypto.passwordHash(senha);
//	}

}
