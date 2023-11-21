package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import controllers.Livros;
import play.db.jpa.Model;

@Entity
public class Compra extends Model {
	
public String EnderecoDeEntrega;
public Cliente ClienteDaCompra;
@ManyToMany
public List<Livro> livroslista;
@Temporal(TemporalType.TIMESTAMP)
public Date data;
}