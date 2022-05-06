package com.ceiba.items_compra.servicio;

import com.ceiba.comando.ComandoItemsCompra;

public class ComandoItemsCompraTestDataBuilder {

	private Long id;
    private Long cantidad;
	private Long idCompra;

	private Long idProducto;

	public ComandoItemsCompraTestDataBuilder() {
		id=3L;
		cantidad = 5L;
		idCompra = 2L;
		idProducto=2L;

	}

	public ComandoItemsCompraTestDataBuilder compraYProducto(Long idCompra, Long idProducto) {
		this.idCompra = idCompra;
		this.idProducto = idProducto;
		return this;
	}

	public ComandoItemsCompra build() {
		return new ComandoItemsCompra(id, cantidad, idCompra,idProducto);
	}
}
