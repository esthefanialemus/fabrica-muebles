package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {
    @Override
    public DtoCliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String identificacion=rs.getString("identificacion");
        String email=rs.getString("email");
        LocalDateTime fechaCreacion=extraerLocalDateTime(rs,"fechaCreacion");
        return new DtoCliente(id,nombre,apellido,identificacion,email,fechaCreacion);
    }
}
