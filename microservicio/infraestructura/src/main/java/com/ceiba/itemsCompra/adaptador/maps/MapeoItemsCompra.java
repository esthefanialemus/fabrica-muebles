package com.ceiba.itemsCompra.adaptador.maps;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.itemsCompra.modelo.dto.DtoItemsCompra;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoItemsCompra implements RowMapper<DtoItemsCompra>, MapperResult {

	@Override
	public DtoItemsCompra mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		Long cantidad = resultSet.getLong("cantidad");


		return new DtoItemsCompra (id,cantidad,mapRowCompra(resultSet),mapRowProducto(resultSet));

	}

	public DtoCompra mapRowCompra(ResultSet resultSet) throws SQLException {

		Long id = resultSet.getLong("id");
		Double total = resultSet.getDouble("total");
		LocalDateTime fechaCompra = extraerLocalDateTime(resultSet, "fechaCompra");
		LocalDateTime fechaEntrega = extraerLocalDateTime(resultSet, "fechaEntrega");
		LocalDateTime fechaDespacho = extraerLocalDateTime(resultSet, "fechaDespacho");

		return new DtoCompra(id, mapRowCliente(resultSet), total, fechaCompra,fechaDespacho,fechaEntrega );
	}

	private DtoCliente mapRowCliente(ResultSet resultSet) throws SQLException {

		Long id = resultSet.getLong("id");
		String nombre = resultSet.getString("nombre");
		String apellido = resultSet.getString("apellido");
		String identificacion = resultSet.getString("identificacion");
		String email = resultSet.getString("email");
		LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fechaCreacion");

		return new DtoCliente(id, nombre, apellido, identificacion, email, fechaCreacion);
	}
	private DtoProducto mapRowProducto(ResultSet resultSet) throws SQLException {

		Long id = resultSet.getLong("id");
		Double valor = resultSet.getDouble("valor");
		String numeroPuesto = resultSet.getString("numeroPuesto");
		String tipoComedor = resultSet.getString("tipoComedor");

		return  new DtoProducto(id,valor,numeroPuesto,tipoComedor);
}
}
