package models;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Crypto;



@Entity
public class Bibliotecarios extends Model {
	
	@Required
	@Min(3)
	@Max(50)
	public String nome;
	
	@Required
	@MinSize(11)
	@MaxSize(11)
	public long cpf;
	
	@Required
	public String email;
	
	@Required
	public String senha;
	
	@Required
	public String funcao;

	
//	public void setSenha(String senha) {
		//vai criptografar a senha antes dela entrar no banco de dados
		//evitando que usuarios que tenha acesso a o BD possam ver as senhas de todos
//		senha = Crypto.passwordHash(senha);
//	}

}
