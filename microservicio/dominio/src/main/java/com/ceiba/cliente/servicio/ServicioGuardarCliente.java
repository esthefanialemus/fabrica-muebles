package com.ceiba.cliente.servicio;

import com.ceiba.cliente.excepcion.ExcepcionUsuarioRepetido;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;

public class ServicioGuardarCliente {
    private static final String MENSAJE_USUARIO_REPETIDO = "El usuario ya existe en el sistema.";

    private final RepositorioCliente repositorioCliente;

    public ServicioGuardarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public void guardar(Cliente cliente) {

        garantizarNoUsuarioRepetido(cliente);

        this.repositorioCliente.guardar(cliente);
    }

    private void garantizarNoUsuarioRepetido(Cliente cliente) {
        if(this.repositorioCliente.existe(cliente.getIdentificacion())) {
            throw new ExcepcionUsuarioRepetido(MENSAJE_USUARIO_REPETIDO);
        }
    }
}
