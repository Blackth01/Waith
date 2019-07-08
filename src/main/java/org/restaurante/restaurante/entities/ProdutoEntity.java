package org.restaurante.restaurante.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.restaurante.restaurante.utils.BaseBean;

@Entity
@Table(name = "produto")
public class ProdutoEntity extends BaseBean {

	private static final long serialVersionUID = 1348695926986732407L;

	
	private Long id;
	
	private String nome;
	
	private String ingredientes;
	
	private Double valor;

	private Set<PedidoEntity> pedidos = new HashSet<PedidoEntity>();
	
	public ProdutoEntity() {
	}
	
	public ProdutoEntity(Long id, String nome, String ingredientes, Double valor) {
		super();
		this.id = id;
		this.nome = nome;
		this.ingredientes = ingredientes;
		this.valor = valor;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@OneToMany(mappedBy = "produto")
	public Set<PedidoEntity> getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}
	
}
