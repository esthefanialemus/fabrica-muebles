
package com.ceiba.consulta.itemscompra;

import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsulta;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsultaSinCompra;
import com.ceiba.items_compra.puerto.dao.DaoItemsCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDaoItemsCompraSinCompra {

	private final DaoItemsCompra daoItemsCompra;

	public ManejadorListarDaoItemsCompraSinCompra(DaoItemsCompra daoItemsCompra) {
		this.daoItemsCompra = daoItemsCompra;
	}
	
	public List<DtoItemsCompraConsultaSinCompra> ejecutar(Long id) {
		return this.daoItemsCompra.listarItemsComprasSinIdCompra(id);
	}

}
