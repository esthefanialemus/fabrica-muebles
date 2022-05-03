package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoUsuario implements RowMapper<DtoUsuario>, MapperResult {
    @Override
    public DtoUsuario mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String clave = rs.getString("clave");

        return new DtoUsuario(id,nombre,clave);

    }
}
