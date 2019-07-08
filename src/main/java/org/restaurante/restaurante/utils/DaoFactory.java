package org.restaurante.restaurante.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.restaurante.restaurante.daos.NumeroDao;
import org.restaurante.restaurante.daos.PedidoDao;
import org.restaurante.restaurante.daos.ProdutoDao;

public final class DaoFactory {

	private DaoFactory() { }

	///////////////////////////////////////////////////////////////////
	// ENTITY MANAGER FACTORY
	///////////////////////////////////////////////////////////////////

	private static final String PERSISTENCE_UNIT_NAME = "restaurantePersistenceUnit";

	private static EntityManagerFactory entityManagerFactoryInstance;

	public static EntityManagerFactory entityManagerFactorInstance() {
		if (entityManagerFactoryInstance == null) {
			entityManagerFactoryInstance = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		}

		return entityManagerFactoryInstance;
	}
	
	///////////////////////////////////////////////////////////////////
	// PRODUTO
	///////////////////////////////////////////////////////////////////

	private static ProdutoDao produtoDaoInstance;

	public static ProdutoDao produtoInstance() {
		if (produtoDaoInstance == null) {
			produtoDaoInstance = new ProdutoDao();
		}

		return produtoDaoInstance;
	}
	
	///////////////////////////////////////////////////////////////////
	// NUMERO
	///////////////////////////////////////////////////////////////////

	private static NumeroDao numeroDaoInstance;

	public static NumeroDao numeroInstance() {
		if (numeroDaoInstance == null) {
			numeroDaoInstance = new NumeroDao();
		}

		return numeroDaoInstance;
	}
	
	///////////////////////////////////////////////////////////////////
	// PEDIDO
	///////////////////////////////////////////////////////////////////

	private static PedidoDao pedidoDaoInstance;

	public static PedidoDao pedidoInstance() {
		if (pedidoDaoInstance == null) {
			pedidoDaoInstance = new PedidoDao();
		}

		return pedidoDaoInstance;
	}
	
}
