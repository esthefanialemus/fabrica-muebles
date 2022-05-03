package com.ceiba.producto.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.producto.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    /**
     * Permite listar productos
     * @return los los productos
     */
    List<DtoProducto> listar();

    /**
     * Permite obtener un objeto dado su id
     *
     * @param id
     * @return el producto
     */
    DtoProducto obtener(Long id);


}
