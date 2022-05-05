package com.ceiba.compra.adaptador.maps;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCompra implements RowMapper<DtoCompra>, MapperResult {

	@Override
	public DtoCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		Long idCliente = resultSet.getLong("idCliente");
		Double total = resultSet.getDouble("total");
		LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fechaCompra");
		LocalDateTime fechaEntrega = extraerLocalDateTime(resultSet, "fechaEntrega");
		LocalDateTime fechaDespacho = extraerLocalDateTime(resultSet, "fechaDespacho");

		return new DtoCompra(id, idCliente, total, fechaCompra, fechaEntrega,fechaDespacho);
	}



}
