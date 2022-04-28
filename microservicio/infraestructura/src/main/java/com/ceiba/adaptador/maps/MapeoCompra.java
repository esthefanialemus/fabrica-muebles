package com.ceiba.adaptador.maps;

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
		Double total = resultSet.getDouble("total");
		LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fechaCompra");
		LocalDateTime fechaEntrega = extraerLocalDateTime(resultSet, "fechaEntrega");
		LocalDateTime fechaDespacho = extraerLocalDateTime(resultSet, "fechaDespacho");

		return new DtoCompra(id, mapRowCliente(resultSet),total, fechaCompra, fechaEntrega, fechaDespacho);
	}

	private DtoCliente mapRowCliente(ResultSet resultSet) throws SQLException {

		Long id = resultSet.getLong("id");
		String nombre = resultSet.getString("nombres");
		String apellido = resultSet.getString("apellidos");
		String identificacion = resultSet.getString("identificacion");
		String email = resultSet.getString("email");
		LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fechaCreacion");

		return new DtoCliente(id, nombre, apellido, identificacion, email, fechaCreacion);
	}

}
