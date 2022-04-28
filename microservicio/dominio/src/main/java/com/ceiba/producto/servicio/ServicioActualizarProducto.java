package com.ceiba.producto.servicio;

import com.ceiba.cliente.entidad.Cliente;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

public class ServicioActualizarProducto {

    private final RepositorioProducto repositorioProducto;


    public ServicioActualizarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar (Cliente producto){


        this.repositorioProducto.actualizar(producto);
    }
}
