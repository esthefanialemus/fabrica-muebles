package com.ceiba.producto.servicio;

import com.ceiba.cliente.entidad.Cliente;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

public class ServicioCrearProducto {

    private final RepositorioProducto repositorioProducto;



    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar (Cliente producto){


        return this.repositorioProducto.crear(producto);
    }


}
