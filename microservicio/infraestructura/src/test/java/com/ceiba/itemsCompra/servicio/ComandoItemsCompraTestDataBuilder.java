package com.ceiba.itemsCompra.servicio;

import com.ceiba.comando.ComandoItemsCompra;

import java.time.LocalDateTime;

public class ComandoItemsCompraTestDataBuilder {

	private Long id;
    private Long cantidad;
	private Long idCompra;

	private Long idProducto;

	public ComandoItemsCompraTestDataBuilder() {
		id=2L;
		cantidad = 5L;
		idCompra = 1L;
		idProducto=2L;

	}



	public ComandoItemsCompra build() {
		return new ComandoItemsCompra(id, cantidad, idCompra,idProducto);
	}
}
