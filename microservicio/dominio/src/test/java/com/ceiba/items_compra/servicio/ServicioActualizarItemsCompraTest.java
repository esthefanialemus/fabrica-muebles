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
    @DisplayName("Deberia validar la existencia previa de la Reserva")
    void deberiaValidarExistenciaPreviaDelItem(){

        // arrange
        ItemsCompra itemsCompra = new ItemTestDataBuilder().validarIdCompraItem(123L).build();

        RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
        Mockito.when(repositorioItemsCompra.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarItemsCompra.ejecutar(itemsCompra), ExcepcionDuplicidad.class,"Estos Items de Compra ya existe en el sistema");
    }


    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {


        ItemsCompra itemsCompra = new ItemTestDataBuilder().validarId(6L).build();
        RepositorioItemsCompra repositorioItemsCompra = Mockito.mock(RepositorioItemsCompra.class);
        Mockito.when(repositorioItemsCompra.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarItemsCompra servicioActualizarItemsCompra = new ServicioActualizarItemsCompra(repositorioItemsCompra);

        servicioActualizarItemsCompra.ejecutar(itemsCompra);

        Mockito.verify(repositorioItemsCompra, Mockito.times(1)).actualizar(itemsCompra);
    }


}