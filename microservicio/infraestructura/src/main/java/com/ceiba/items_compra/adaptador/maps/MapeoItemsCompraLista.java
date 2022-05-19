package com.ceiba.items_compra.adaptador.maps;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompra;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsulta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoItemsCompraLista implements RowMapper<DtoItemsCompraConsulta>, MapperResult {


	@Override
	public DtoItemsCompraConsulta mapRow(ResultSet resultSet, int rowNum) throws SQLException {


		Long cantidad = resultSet.getLong("cantidad");
		Double valor = resultSet.getDouble("valor");
		String numeroPuesto = resultSet.getString("numeroPuesto");
		String tipoComedor = resultSet.getString("tipoComedor");
		Double total = resultSet.getDouble("total");
		LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fechaCompra");

		return  new DtoItemsCompraConsulta(cantidad,valor,numeroPuesto,tipoComedor,total,fechaCompra);

	}



}
