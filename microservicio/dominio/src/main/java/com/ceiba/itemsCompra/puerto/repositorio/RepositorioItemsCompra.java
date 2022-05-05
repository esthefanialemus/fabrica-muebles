package com.ceiba.itemsCompra.puerto.repositorio;

import com.ceiba.itemsCompra.modelo.entidad.itemsCompra;

public interface RepositorioItemsCompra {
    /**
     * Permite crear un ItemsCompra
     *
     * @param ItemsCompra
     * @return el id generado
     */
    Long crear(itemsCompra ItemsCompra);

    /**
     * Permite actualizar un ItemsCompra
     *
     * @param ItemsCompra
     */
    void actualizar(itemsCompra ItemsCompra);

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
