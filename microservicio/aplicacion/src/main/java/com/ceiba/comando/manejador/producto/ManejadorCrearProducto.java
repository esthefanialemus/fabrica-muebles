package com.ceiba.comando.manejador.producto;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoUsuario;
import com.ceiba.comando.fabrica.FabricaProducto;
import com.ceiba.comando.manejador.ComandoProducto;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProducto {

    private  final FabricaProducto fabricaProducto;

    private  final ServicioCrearProducto servicioCrearProducto;

    public ManejadorCrearProducto(FabricaProducto fabricaProducto, ServicioCrearProducto servicioCrearProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioCrearProducto = servicioCrearProducto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoProducto comandoProducto) {
        Producto producto = this.fabricaProducto.crear(comandoProducto);
        return new ComandoRespuesta<>(this.servicioCrearProducto.ejecutar(producto));
    }
}
