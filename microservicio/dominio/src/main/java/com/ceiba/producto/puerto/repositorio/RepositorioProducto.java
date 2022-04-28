package com.ceiba.producto.puerto.repositorio;

import com.ceiba.cliente.entidad.Producto;

public interface RepositorioProducto {
    /**
     * Permite crear un Producto
     *
     * @param producto
     * @return el id generado
     */
    Long crear(Producto producto);

    /**
     * Permite actualizar un Producto
     *
     * @param producto
     */
    void actualizar(Producto producto);

    /**
     * Permite eliminar un Producto
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un Producto con un id
     *
     * @param identificacion
     * @return si existe o no
     */
    boolean existe(String identificacion);

    /**
     * Permite validar si existe un Producto con una id
     *
     * @param id
     * @return si existe o no
     */

}
