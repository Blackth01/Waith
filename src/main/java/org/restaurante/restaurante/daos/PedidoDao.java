package org.restaurante.restaurante.daos;

import java.util.List;

import org.restaurante.restaurante.entities.PedidoEntity;
import org.restaurante.restaurante.utils.GenericDao;

public class PedidoDao extends GenericDao<PedidoEntity, Long>{
	@SuppressWarnings("unchecked")
	public List<PedidoEntity> getPedidos(Long numero) {
		
		List<PedidoEntity> resultado = (List<PedidoEntity>)
				this.executeQuery("SELECT p FROM PedidoEntity p, NumeroEntity n WHERE p.numero.id=n.id AND n.id= ?0", numero);
		
		return resultado;
	}
}
