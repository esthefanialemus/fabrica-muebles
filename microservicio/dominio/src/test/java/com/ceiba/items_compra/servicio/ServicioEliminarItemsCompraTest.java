package com.ceiba.items_compra.servicio;

import com.ceiba.compra.servicio.ServicioEliminarCompra;
import com.ceiba.items_compra.puerto.repositorio.RepositorioItemsCompra;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarItemsCompraTest {

    @Test
    @DisplayName("Deberia eliminar el item de la compra")
    void eliminarElItemCompra(){

        // arrange

        RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);

        ServicioEliminarItemsCompra servicioEliminarItemsCompra = new ServicioEliminarItemsCompra(repositorioItemsCompra);

        servicioEliminarItemsCompra.ejecutar(1L);
        // act - assert
        Mockito.verify(repositorioItemsCompra,Mockito.times(1)).eliminar(1L);
    }







}