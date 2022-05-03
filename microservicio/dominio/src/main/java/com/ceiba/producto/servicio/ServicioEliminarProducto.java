package com.ceiba.producto.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;

public class ServicioEliminarProducto {



    private final RepositorioProducto repositorioProducto;


    public ServicioEliminarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar (Long  id)
    {
        this.repositorioProducto.eliminar(id);
    }


}
