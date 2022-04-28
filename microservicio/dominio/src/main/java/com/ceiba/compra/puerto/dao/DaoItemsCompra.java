package com.ceiba.compra.puerto.dao;

import com.ceiba.compra.modelo.dto.DtoItemsCompra;

import java.util.List;

public interface DaoItemsCompra {
    /**
     * Permite listar items de compra
     * @return los Crsitales
     */
    List<DtoItemsCompra> listar();

    /**
     * Permite obtener los items de la compra dado su id
     *
     * @param id
     * @return el Cristal
     */
    DtoItemsCompra obtener(Long id);

}
