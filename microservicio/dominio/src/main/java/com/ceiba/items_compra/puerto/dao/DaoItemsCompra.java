package com.ceiba.items_compra.puerto.dao;

import com.ceiba.items_compra.modelo.dto.DtoItemsCompra;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsulta;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsultaSinCompra;

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

    /**
     * Permite listar los items de la compra
     *
     * @return Los ItemsCompras
     */
    List <DtoItemsCompraConsulta> listarCompras(Long id);


    /**
     * Permite listar los items de la compra sin relacionar la compra
     *
     * @return Los ItemsCompras
     */
    List <DtoItemsCompraConsultaSinCompra> listarItemsComprasSinIdCompra(Long id);


}
