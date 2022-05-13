package com.ceiba.items_compra.puerto.repositorio;

import com.ceiba.items_compra.modelo.entidad.ItemsCompra;

public interface RepositorioItemsCompra {
    /**
     * Permite crear un ItemsCompra
     *
     * @param itemsCompra
     * @return el id generado
     */
    Long crear(ItemsCompra itemsCompra);

    /**
     * Permite actualizar un ItemsCompra
     *
     * @param itemsCompra
     */
    void actualizar(ItemsCompra itemsCompra);

    /**
     * Permite eliminar un ItemsCompra
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un ItemsCompra con una  compra
     *
     * @param idCompra
     * @return si existe o no
     */
    boolean existe(Long idCompra);

    /**
     * Permite validar si existe un ItemsCompra excluyendo un id
     *
     * @param id
     * @param idCompra
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,Long idCompra);

}
