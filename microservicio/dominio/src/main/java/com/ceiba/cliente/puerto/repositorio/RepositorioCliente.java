package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.entidad.Cliente;

public interface RepositorioCliente {

    /**
     * Permite crear un Cliente
     *
     * @param cliente
     * @return el id generado
     */
    Long crear(Cliente cliente);

    /**
     * Permite actualizar un cliente
     *
     * @param cliente
     */
    void actualizar(Cliente cliente);

    /**
     * Permite eliminar un cliente
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un Cliente con una identificacion
     *
     * @param identificacion
     * @return si existe o no
     */
    boolean existe(String identificacion);

    /**
     * Permite validar si existe un Cliente con una identificacion excluyendo un id
     *
     * @param identificacion
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String identificacion);
}
