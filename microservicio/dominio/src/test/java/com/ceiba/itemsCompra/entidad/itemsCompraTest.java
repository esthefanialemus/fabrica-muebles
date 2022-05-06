package com.ceiba.itemsCompra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemsCompra.servicio.testdatabuilder.ItemTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class itemsCompraTest {

    @Test
    @DisplayName("Deberia crear  correctamente el item de la compra")
    void deberiaCrearCorrectamenteItemscompra (){
        ItemsCompra itemsCompra = new ItemTestDataBuilder().build();

        assertEquals(6L, itemsCompra.getId());
        assertEquals(1L, itemsCompra.getCantidad());
        assertEquals(1L, itemsCompra.getIdCompra());
        assertEquals(2L, itemsCompra.getIdProducto());

    }
    @Test
    @DisplayName("Deberia fallar la creacion sin la cantidad de items de la compra")
    void deberiaFallarSinCantidadItemsProducto() {
        ItemTestDataBuilder itemTestDataBuilder = new ItemTestDataBuilder().validarCantidadItemsProducto(null);
        BasePrueba.assertThrows(() -> {
                    itemTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad del producto");

    }

    @Test
    @DisplayName("Deberia fallar la creacion sin el id de la compra del item")
    void deberiaFallarSinIdCompraItem() {
        ItemTestDataBuilder itemTestDataBuilder = new ItemTestDataBuilder().validarIdCompraItem(null);
        BasePrueba.assertThrows(() -> {
                    itemTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe asignar la compra");

    }

    @Test
    @DisplayName("Deberia fallar la creacion sin el producto del item ")
    void deberiaFallarSinIdProductoItem() {
        ItemTestDataBuilder itemTestDataBuilder = new ItemTestDataBuilder().validarIdProductoItem(null);
        BasePrueba.assertThrows(() -> {
                    itemTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe asignar el producto");

    }

}