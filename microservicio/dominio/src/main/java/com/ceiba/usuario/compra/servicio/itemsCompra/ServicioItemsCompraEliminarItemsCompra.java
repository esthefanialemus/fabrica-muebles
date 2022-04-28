package com.ceiba.usuario.compra.servicio.itemsCompra;

import com.ceiba.usuario.compra.puerto.repositorio.RepositorioItemsCompra;

public class ServicioItemsCompraEliminarItemsCompra {
    private final RepositorioItemsCompra repositorioItemsCompra;



    public ServicioItemsCompraEliminarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
        this.repositorioItemsCompra = repositorioItemsCompra;
    }

    public void ejecutar(Long id) {
        this.repositorioItemsCompra.eliminar(id);
    }

}
