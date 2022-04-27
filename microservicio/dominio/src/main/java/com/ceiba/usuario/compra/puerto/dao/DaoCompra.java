package com.ceiba.usuario.compra.puerto.dao;

import com.ceiba.usuario.compra.modelo.dto.DtoCompra;

public interface DaoCompra {

    public DtoCompra listarCompraPorId (Long idCompra);
}
