
package com.ceiba.consulta.itemsCompra;

import com.ceiba.compra.modelo.dto.DtoItemsCompra;
import com.ceiba.compra.puerto.dao.DaoItemsCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerItemsCompra {
	
	private final DaoItemsCompra daoItemsCompra;

	public ManejadorObtenerItemsCompra(DaoItemsCompra daoItemsCompra) {
		this.daoItemsCompra = daoItemsCompra;
	}
	
	public DtoItemsCompra ejecutar(Long id) {
		return this.daoItemsCompra.obtener(id);
	}

}
