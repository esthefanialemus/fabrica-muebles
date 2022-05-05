package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.itemsCompra.modelo.entidad.itemsCompra;
import org.springframework.stereotype.Component;

@Component
public class FabricaItemsCompra {

	public itemsCompra crear(ComandoItemsCompra comandoItemsCompra) {
		return new itemsCompra(comandoItemsCompra.getId(), comandoItemsCompra.getCantidad(), comandoItemsCompra.getIdCompra(), comandoItemsCompra.getIdProducto());

	}

}
