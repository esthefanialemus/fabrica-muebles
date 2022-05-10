package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCliente {

    private static final String EL_CLIENTE_EXISTE_EN_EL_SISTEMA = "El Cliente ya existe en el sistema";

    private final RepositorioCliente repositorioCliente;

    public ServicioActualizarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void ejecutar(Cliente cliente) {
        if(validarExistenciaPrevia(cliente)){
            throw new ExcepcionDuplicidad(EL_CLIENTE_EXISTE_EN_EL_SISTEMA);
        }else{
            this.repositorioCliente.actualizar(cliente);
        }

    }

    private boolean validarExistenciaPrevia(Cliente cliente) {
        return (this.repositorioCliente.existe(cliente.getIdentificacion())) ;


    }
}
