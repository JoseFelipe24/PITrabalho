package models;


import java.util.Date;
import javax.persistence.Entity;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Livro extends Model{

	public String nome;
	public String autor;
	public Date ano;
	public String genero;
	public String classificacao;
	public String sinopse;
	public Blob Imagem;
	public double preco;
	public String nomeImagem;
	
	
}
