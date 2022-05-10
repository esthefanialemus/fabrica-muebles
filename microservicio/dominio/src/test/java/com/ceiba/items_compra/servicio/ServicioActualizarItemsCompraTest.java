package com.ceiba.items_compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.items_compra.modelo.entidad.ItemsCompra;
import com.ceiba.items_compra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.items_compra.servicio.testdatabuilder.ItemTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioActualizarItemsCompraTest {

    @Test
    @DisplayName("Deberia actualizar el item de la compra")
    void deberiaActualizarElItemDeLaCompra(){

        // arrange
        ItemsCompra itemsCompra = new ItemTestDataBuilder().validarIdCompraItem(123L).build();

        RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
        Mockito.when(repositorioItemsCompra.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarItemsCompra.ejecutar(itemsCompra), ExcepcionDuplicidad.class,"Estos Items de Compra ya existe en el sistema");
    }







}