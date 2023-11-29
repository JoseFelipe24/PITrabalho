package models;

import java.util.Date;
import javax.persistence.Entity;

import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Blob;
import play.db.jpa.Model;

@Entity
public class Livro extends Model {

	@Required
	public String nome;

	@Required
	public String autor;

	@Required
	public Date ano;

	@Required
	public String genero;

	@Required

	public String classificacao;

	@Required
	public String sinopse;

	@Required
	public Blob Imagem;

	@Required
	public double preco;

	@Required
	public int numeropag;

	@Required
	public String Idioma;

	@Required
	public String Editora;

	@Required
	public String TipoDeLivro;

	@Required
	public String nomeImagem;
}
