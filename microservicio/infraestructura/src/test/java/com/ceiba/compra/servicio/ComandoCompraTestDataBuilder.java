package com.ceiba.compra.servicio;

import com.ceiba.comando.ComandoCompra;

import java.time.LocalDateTime;

public class ComandoCompraTestDataBuilder {

	private Long id;
	private Long idCliente;
    private Double total;
	private LocalDateTime fechaCompra;
	private LocalDateTime fechaEntrega;

	private LocalDateTime fechaDespacho;

	public ComandoCompraTestDataBuilder() {

		idCliente = 2L;
		total = 250000D;
		fechaCompra = LocalDateTime.now();
		fechaEntrega = LocalDateTime.now().plusDays(6);
		fechaDespacho = LocalDateTime.now().plusDays(6);

	}

	public ComandoCompra build() {
		return new ComandoCompra(id, idCliente, total, fechaCompra, fechaEntrega,fechaDespacho);
	}
}
