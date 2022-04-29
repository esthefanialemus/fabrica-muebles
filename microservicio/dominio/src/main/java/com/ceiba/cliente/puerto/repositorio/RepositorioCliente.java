package com.ceiba.cliente.puerto.repositorio;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;

import java.util.List;

public interface RepositorioCliente {


    List<DtoCliente> listar();

    void guardar(Cliente cliente);

    boolean existe(String identificacion);

    /**
     * Permite crear un Cliente
     *
     * @param Cliente
     * @return el id generado
     */
    Long crear(Cliente Cliente);

    /**
     * Permite actualizar un Cliente
     *
     * @param Cliente
     */
    void actualizar(Cliente Cliente);

    /**
     * Permite eliminar un Cliente
     *
     * @param id
     */
    void eliminar(Long id);


    /**
     * Permite validar si existe un Cliente con una identificacion excluyendo un id
     *
     * @param identificacion
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, String identificacion);

}
