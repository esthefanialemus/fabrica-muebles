package com.ceiba.comando.fabrica;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.comando.ComandoCliente;
import org.springframework.stereotype.Component;

@Component
public class FabricaCliente {

    public Cliente crear (ComandoCliente comandoCliente) {
        return new Cliente(comandoCliente.getId(),  comandoCliente.getNombre(),
                comandoCliente.getApellido(), comandoCliente.getIdentificacion(), comandoCliente.getEmail());

    }
}
