package com.ceiba.items_compra.servicio;

import com.ceiba.items_compra.puerto.repositorio.RepositorioItemsCompra;

public class ServicioEliminarItemsCompra {

	private final RepositorioItemsCompra repositorioItemsCompra;

	public ServicioEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
	}

	public void ejecutar(Long id) {
		this.repositorioItemsCompra.eliminar(id);
	}
}
