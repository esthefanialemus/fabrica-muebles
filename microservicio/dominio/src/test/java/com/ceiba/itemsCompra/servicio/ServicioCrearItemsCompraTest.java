package com.ceiba.itemsCompra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.ServicioCrearCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.itemsCompra.servicio.testdatabuilder.ItemTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearItemsCompraTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el item de la compra ya exista")
    void deberiaValidarExistenciaPreviaDelItemsCompra(){

        // arrange
        ItemsCompra itemsCompra = new ItemTestDataBuilder().build();
        RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
        Mockito.when(repositorioItemsCompra.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearItemsCompra.ejecutar(itemsCompra), ExcepcionDuplicidad.class,"Estos Items de Compra ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear el item de la compra de manera correcta")
    void deberiaCrearItemDeLaCompraCorrectamente(){

        // arrange
        ItemsCompra itemsCompra = new ItemTestDataBuilder().build();
        RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
        Mockito.when(repositorioItemsCompra.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioItemsCompra.crear(itemsCompra)).thenReturn(1L);
        ServicioCrearItemsCompra servicioCrearItemsCompra = new ServicioCrearItemsCompra(repositorioItemsCompra);
        // act
        Long idCompra = servicioCrearItemsCompra.ejecutar(itemsCompra);
        // - assert
        assertEquals(1L,idCompra);
        Mockito.verify(repositorioItemsCompra, Mockito.times(1)).crear(itemsCompra);
    }







}