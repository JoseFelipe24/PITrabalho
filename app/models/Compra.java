package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import controllers.Livros;
import play.db.jpa.Model;

@Entity
public class Compra extends Model {
	
public String EnderecoDeEntrega;
public Cliente ClienteDaCompra;
@OneToMany
public List<Livros> livroslista;
}
