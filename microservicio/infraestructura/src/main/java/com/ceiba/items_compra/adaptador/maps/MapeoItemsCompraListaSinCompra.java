package com.ceiba.items_compra.adaptador.maps;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsulta;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsultaSinCompra;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoItemsCompraListaSinCompra implements RowMapper<DtoItemsCompraConsultaSinCompra>, MapperResult {


	@Override
	public DtoItemsCompraConsultaSinCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {


		Long cantidad = resultSet.getLong("cantidad");
		Double valor = resultSet.getDouble("valor");
		String numeroPuesto = resultSet.getString("numeroPuesto");
		String tipoComedor = resultSet.getString("tipoComedor");

		return  new DtoItemsCompraConsultaSinCompra(cantidad,valor,numeroPuesto,tipoComedor);

	}



}
