package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.items_compra.modelo.entidad.ItemsCompra;
import org.springframework.stereotype.Component;

@Component
public class FabricaItemsCompra {

	public ItemsCompra crear(ComandoItemsCompra comandoItemsCompra) {
		return new ItemsCompra(comandoItemsCompra.getId(), comandoItemsCompra.getCantidad(), comandoItemsCompra.getIdCompra(), comandoItemsCompra.getIdProducto());

	}

}
