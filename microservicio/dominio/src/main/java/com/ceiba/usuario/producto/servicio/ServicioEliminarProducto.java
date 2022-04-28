package com.ceiba.usuario.producto.servicio;

import com.ceiba.usuario.cliente.entidad.Producto;
import com.ceiba.usuario.producto.puerto.repositorio.RepositorioProducto;

public class ServicioEliminarProducto {
    private final RepositorioProducto repositorioProducto;



    public ServicioEliminarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar (Long id){


        this.repositorioProducto.eliminar(id);
    }
}
