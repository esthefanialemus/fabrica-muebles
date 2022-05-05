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

		idCliente = 1L;
		total = 250000D;
		fechaCompra = LocalDateTime.now();
		fechaDespacho = LocalDateTime.now().plusDays(4);
		fechaEntrega = LocalDateTime.now().plusDays(6);

	}

	public ComandoCompraTestDataBuilder conFechaEntregaCompraYCliente(Long idCliente, LocalDateTime fechaCompra, LocalDateTime fechaEntrega) {
		this.idCliente = idCliente;
		this.fechaCompra = fechaCompra;
		this.fechaEntrega = fechaEntrega;
		return this;
	}

	public ComandoCompra build() {
		return new ComandoCompra(id, idCliente, total, fechaCompra, fechaEntrega,fechaDespacho);
	}
}
