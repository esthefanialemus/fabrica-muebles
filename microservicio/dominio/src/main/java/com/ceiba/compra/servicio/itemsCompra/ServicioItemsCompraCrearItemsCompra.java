package com.ceiba.compra.servicio.itemsCompra;

import com.ceiba.compra.modelo.entidad.ItemsCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.dominio.excepcion.ExcepcionItemsCompraVacio;

public class ServicioItemsCompraCrearItemsCompra {

    private static final String ITEMS_COMPRA_VACIO = "La cantidad de items no puede ser cero";


    private final RepositorioItemsCompra repositorioItemsCompra;

    public ServicioItemsCompraCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
        this.repositorioItemsCompra = repositorioItemsCompra;
    }

    public Long ejecutar (ItemsCompra itemsCompra){
        validarItemsCompraVacio(itemsCompra);

        return this.repositorioItemsCompra.crear(itemsCompra);
    }

    private void validarItemsCompraVacio(ItemsCompra itemsCompra) {
        if (itemsCompra.getCantidad() < 1 )
        {
                throw  new ExcepcionItemsCompraVacio(ITEMS_COMPRA_VACIO);
        }
    }
}
