package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {
    @Override
    public DtoProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        Double valor = rs.getDouble("valor");
        String numeroPuesto = rs.getString("numeroPuesto");
        String tipoComedor=rs.getString("tipoComedor");

        return new DtoProducto(id,valor,numeroPuesto,tipoComedor);
    }
}
