package com.ceiba.usuario.producto.servicio;

import com.ceiba.usuario.cliente.entidad.Producto;
import com.ceiba.usuario.producto.puerto.repositorio.RepositorioProducto;

public class ServicioCrearProducto {

    private final RepositorioProducto repositorioProducto;



    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Long ejecutar (Producto producto){


        return this.repositorioProducto.crear(producto);
    }


}
