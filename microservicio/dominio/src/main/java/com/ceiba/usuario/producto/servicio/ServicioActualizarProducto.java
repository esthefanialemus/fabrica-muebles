package com.ceiba.usuario.producto.servicio;

import com.ceiba.usuario.cliente.entidad.Producto;
import com.ceiba.usuario.producto.puerto.repositorio.RepositorioProducto;

public class ServicioActualizarProducto {

    private final RepositorioProducto repositorioProducto;


    public ServicioActualizarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar (Producto producto){


        this.repositorioProducto.actualizar(producto);
    }
}
