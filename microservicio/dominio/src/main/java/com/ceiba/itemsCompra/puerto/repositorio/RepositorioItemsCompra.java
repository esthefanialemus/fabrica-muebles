package com.ceiba.itemsCompra.puerto.repositorio;

import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;

import java.time.LocalDateTime;

public interface RepositorioItemsCompra {
    /**
     * Permite crear un ItemsCompra
     *
     * @param ItemsCompra
     * @return el id generado
     */
    Long crear(ItemsCompra ItemsCompra);

    /**
     * Permite actualizar un ItemsCompra
     *
     * @param ItemsCompra
     */
    void actualizar(ItemsCompra ItemsCompra);

    /**
     * Permite eliminar un ItemsCompra
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un ItemsCompra con una fecha y compra
     *
     * @param fechaCreacion
     * @param idCompra
     * @return si existe o no
     */
    boolean existe(LocalDateTime fechaCreacion, Long idCompra);

    /**
     * Permite validar si existe un ItemsCompra con una fecha excluyendo un id
     *
     * @param id
     * @param fechaCreacion
     * @param idCompra
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, LocalDateTime fechaCreacion,Long idCompra);
}
