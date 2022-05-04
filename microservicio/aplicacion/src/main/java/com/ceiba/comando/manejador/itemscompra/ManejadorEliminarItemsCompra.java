
package com.ceiba.comando.manejador.itemscompra;

import com.ceiba.itemsCompra.servicio.ServicioEliminarItemsCompra;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarItemsCompra implements ManejadorComando<Long> {

    private final com.ceiba.itemsCompra.servicio.ServicioEliminarItemsCompra ServicioEliminarItemsCompra;

    public ManejadorEliminarItemsCompra(ServicioEliminarItemsCompra ServicioEliminarItemsCompra) {
        this.ServicioEliminarItemsCompra = ServicioEliminarItemsCompra;
    }

    public void ejecutar(Long idRol) {
        this.ServicioEliminarItemsCompra.ejecutar(idRol);
    }
}
