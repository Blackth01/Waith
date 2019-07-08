package org.restaurante.restaurante.daos;

import java.util.List;

import org.restaurante.restaurante.entities.ProdutoEntity;
import org.restaurante.restaurante.utils.GenericDao;

public class ProdutoDao extends GenericDao<ProdutoEntity, Long> {
	
	@SuppressWarnings("unchecked")
	public List<ProdutoEntity> pesquisaProdutos(String pesquisa) {
		
		List<ProdutoEntity> resultado = (List<ProdutoEntity>)
				this.executeQuery("SELECT p FROM ProdutoEntity p WHERE p.nome LIKE '%"+pesquisa+"%'");
		
		return resultado;
	}
}
