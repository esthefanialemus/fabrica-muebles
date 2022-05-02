package com.ceiba.adaptador.maps;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

    @Override
    public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
    	 String nombre = resultSet.getString("nombre");
    	 String apellido = resultSet.getString("apellido");
    	 String identificacion = resultSet.getString("identificacion");
    	 String email = resultSet.getString("email");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fechaCreacion");


        return new DtoCliente(id, nombre, apellido, identificacion, email, fechaCreacion);

    }

}
 