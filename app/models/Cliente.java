package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Cliente extends Model{

	public String nome;
	public long cpf;
	public String email;
	public String senha;
	public String preferenciaGenero;
	public String endereco;
	@OneToMany
	@JoinColumn(name="idCompra")
	public List<Compra> listaCompras;
}
