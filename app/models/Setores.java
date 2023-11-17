package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import play.db.jpa.Model;

@Entity
public class Setores extends Model{

	public String nome;
	
    
	@OneToMany
	@JoinColumn(name="idSetor")
	public List<Bibliotecarios> bibliotecariolista;

}
