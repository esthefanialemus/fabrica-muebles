package com.ceiba.itemsCompra.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.itemsCompra.adaptador.maps.MapeoItemsCompra;
import com.ceiba.itemsCompra.modelo.dto.DtoItemsCompra;
import com.ceiba.itemsCompra.puerto.dao.DaoItemsCompra;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DaoItemsCompraMysql implements DaoItemsCompra {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="itemsCompra", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="itemsCompra", value="obtener")
    private static String sqlObtener;
      
    
    public DaoItemsCompraMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


	@Override
	public List<DtoItemsCompra> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoItemsCompra());

	}


	@Override
	public DtoItemsCompra obtener(Long id) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoItemsCompra()).iterator().next();
	}




}
