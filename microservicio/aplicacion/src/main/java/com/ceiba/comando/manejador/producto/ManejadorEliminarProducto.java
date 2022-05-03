package com.ceiba.comando.manejador.producto;

import com.ceiba.producto.servicio.ServicioEliminarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProducto {

    private final ServicioEliminarProducto servicioEliminarProducto;


    public ManejadorEliminarProducto(ServicioEliminarProducto servicioEliminarProducto) {
        this.servicioEliminarProducto = servicioEliminarProducto;
    }

    public void ejecutar(Long idProducto){
        this.servicioEliminarProducto.ejecutar(idProducto);
    }
}
