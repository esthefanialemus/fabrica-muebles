
package com.ceiba.consulta.itemscompra;

import com.ceiba.itemsCompra.modelo.dto.DtoItemsCompra;
import com.ceiba.itemsCompra.puerto.dao.DaoItemsCompra;
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
