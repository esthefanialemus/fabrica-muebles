package com.ceiba.comando.manejador.producto;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoUsuario;
import com.ceiba.comando.fabrica.FabricaProducto;
import com.ceiba.comando.manejador.ComandoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ManejadorActualizarProducto {


    private  final FabricaProducto fabricaProducto;

    private  final ServicioCrearProducto servicioActualizarProducto;

    public ManejadorActualizarProducto(FabricaProducto fabricaProducto, ServicioCrearProducto servicioCrearProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioActualizarProducto = servicioCrearProducto;
    }

    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        this.servicioActualizarProducto.ejecutar(producto);
    }
}
