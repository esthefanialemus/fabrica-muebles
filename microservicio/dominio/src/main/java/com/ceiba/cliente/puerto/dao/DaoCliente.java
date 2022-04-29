package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;

import java.util.List;

public interface DaoCliente {

    /**
     * Permite listar Clientes
     * @return los Clientes
     */
    List<DtoCliente> listar();

    /**
     * Permite obtener un Cliente dado su identificacion
     *
     * @param identificacion
     * @return el Cliente
     */
    DtoCliente obtener(String identificacion);

}
