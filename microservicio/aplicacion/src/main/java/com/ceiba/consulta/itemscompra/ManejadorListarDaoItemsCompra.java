
package com.ceiba.consulta.itemscompra;

import com.ceiba.items_compra.modelo.dto.DtoItemsCompra;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsulta;
import com.ceiba.items_compra.puerto.dao.DaoItemsCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarDaoItemsCompra {

	private final DaoItemsCompra daoItemsCompra;

	public ManejadorListarDaoItemsCompra(DaoItemsCompra daoItemsCompra) {
		this.daoItemsCompra = daoItemsCompra;
	}
	
	public List<DtoItemsCompraConsulta> ejecutar(Long id) {
		return this.daoItemsCompra.listarCompras(id);
	}

}
