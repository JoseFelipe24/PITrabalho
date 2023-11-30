package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import controllers.Livros;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Compra extends Model {

	


	public String enderecoDeEntrega;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	public Cliente cliente;

	@ManyToMany
	public List<Livro> livroslista;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date data;

	public Compra() {
		data = new Date();
	}
}
