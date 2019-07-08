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
@Table(name = "numero")
public class NumeroEntity extends BaseBean{

	private static final long serialVersionUID = -1759104813172914325L;
	
	private Long id;
	
	private Double total;

	private Set<PedidoEntity> pedidos = new HashSet<PedidoEntity>();
	
	public NumeroEntity() {
	}
	
	public NumeroEntity(Long id, Double total) {
		super();
		this.id = id;
		this.total = total;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@OneToMany(mappedBy = "numero")
	public Set<PedidoEntity>getPedidos() {
		return pedidos;
	}

	public void setPedidos(Set<PedidoEntity> pedidos) {
		this.pedidos = pedidos;
	}
	
}
