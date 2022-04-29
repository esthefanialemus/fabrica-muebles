package com.ceiba.servicio;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ServicioAplicacionListarCliente {

    private final RepositorioCliente repositorioCliente;


    public ServicioAplicacionListarCliente(RepositorioCliente repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public List<DtoCliente> ejecutar(){ return  this.repositorioCliente.listar();}
}
