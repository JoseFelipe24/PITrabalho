package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Cliente extends Model {

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
	@Min(8)
	@Max(20)
	public String senha;

	@Required
	public String preferenciaGenero;

	@Required
	public String endereco;
	@OneToMany
	@JoinColumn(name = "idCompra")
	public List<Compra> listaCompras;
}
