package com.ceiba.comando.fabrica;

import com.ceiba.comando.manejador.ComandoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {

    public Producto crear (ComandoProducto comandondoProducto){
        return  new Producto(comandondoProducto.getId(), comandondoProducto.getValor(), comandondoProducto.getNumeroPuesto(), comandondoProducto.getTipoComedor());
    }
}
