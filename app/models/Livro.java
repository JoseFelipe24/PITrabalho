package models;

import java.util.Date;

import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity
public class Livro extends Model{

	public String autor;
	public Date ano;
	public String nome;
	public String genero;
	public String classificacao;
	public String sinopse;
	public String Imagem;
	public double preco;
	
	
}
