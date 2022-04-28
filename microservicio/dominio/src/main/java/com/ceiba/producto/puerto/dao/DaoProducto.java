package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {
    /**
     * Permite listar Productos
     * @return los Productos
     */
    List<DtoProducto> listar();

    /**
     * Permite obtener un Producto dado su id
     *
     * @param 'id
     * @return el Producto
     */
    DtoProducto obtener(Long identificacion);
}
