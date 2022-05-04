package com.ceiba.comando.manejador.compra;

import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarCompra implements ManejadorComando<Long> {

    private final ServicioEliminarCompra servicioEliminarCompra;

    public ManejadorEliminarCompra(ServicioEliminarCompra servicioEliminarCompra) {
        this.servicioEliminarCompra = servicioEliminarCompra;
    }

    public void ejecutar(Long idCompra) {
        this.servicioEliminarCompra.ejecutar(idCompra);
    }
}
