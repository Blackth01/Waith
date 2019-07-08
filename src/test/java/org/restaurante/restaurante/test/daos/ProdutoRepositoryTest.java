package org.restaurante.restaurante.test.daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.restaurante.restaurante.daos.ProdutoDao;
import org.restaurante.restaurante.entities.ProdutoEntity;
import org.restaurante.restaurante.utils.DaoFactory;

public class ProdutoRepositoryTest {
	
	private static final Logger LOGGER = Logger.getLogger(ProdutoRepositoryTest.class);
	
	private ProdutoDao produtoDao = DaoFactory.produtoInstance();
	
	@Test
	public void testFindAll() {
		List<ProdutoEntity> produtos = this.produtoDao.findAll();
		
		LOGGER.info(produtos);
	}
	
}
