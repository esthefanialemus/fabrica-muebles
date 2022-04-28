package com.ceiba.compra.servicio.itemsCompra;

import com.ceiba.compra.puerto.repositorio.RepositorioItemsCompra;

public class ServicioItemsCompraEliminarItemsCompra {
    private final RepositorioItemsCompra repositorioItemsCompra;



    public ServicioItemsCompraEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
        this.repositorioItemsCompra = repositorioItemsCompra;
    }

    public void ejecutar(Long id) {
        this.repositorioItemsCompra.eliminar(id);
    }

}
