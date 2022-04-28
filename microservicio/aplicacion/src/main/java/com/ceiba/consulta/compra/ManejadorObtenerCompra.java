
package com.ceiba.consulta.compra;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerCompra {
	
	private final DaoCompra daoCompra;

	public ManejadorObtenerCompra(DaoCompra daoCompra) {
		this.daoCompra = daoCompra;
	}
	
	public DtoCompra ejecutar(Long id) {
		return this.daoCompra.obtener(id);
	}

}
