package com.ceiba.items_compra.adaptador.maps;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompra;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoItemsCompra implements RowMapper<DtoItemsCompra>, MapperResult {


	@Override
	public DtoItemsCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		Long cantidad = resultSet.getLong("cantidad");

		Long idCompra = resultSet.getLong("idCompra");
		Long idProducto = resultSet.getLong("idProducto");

		return  new DtoItemsCompra(id,cantidad,idCompra,idProducto);

	}



}
