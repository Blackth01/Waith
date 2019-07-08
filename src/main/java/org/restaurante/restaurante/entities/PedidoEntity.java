package org.restaurante.restaurante.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.restaurante.restaurante.utils.BaseBean;

@Entity
@Table(name = "pedido")
public class PedidoEntity extends BaseBean{

	private static final long serialVersionUID = -6689641480422363011L;

	private Long id;
	
	private int quantidade;

	private NumeroEntity numero;
	private ProdutoEntity produto;
	
	
	public PedidoEntity() {
	}
	
	public PedidoEntity(Long id, int quantidade) {
		super();
		this.id = id;
		this.quantidade = quantidade;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

    //@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
    @JoinColumn(name = "id_numero")  
	public NumeroEntity getNumero() {
		return numero;
	}

	public void setNumero(NumeroEntity numero) {
		this.numero = numero;
	}

    //@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
    @JoinColumn(name = "id_produto")  
	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}
	
}
