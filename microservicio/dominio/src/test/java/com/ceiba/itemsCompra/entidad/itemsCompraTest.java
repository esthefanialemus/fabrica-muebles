package com.ceiba.itemsCompra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.itemsCompra.modelo.entidad.itemsCompra;
import com.ceiba.itemsCompra.servicio.ItemTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class itemsCompraTest {

    @Test
    void deberiaCrearCorrectamenteItemscompra (){
        itemsCompra itemsCompra = new ItemTestDataBuilder().build();

        assertEquals(6L, itemsCompra.getId());
        assertEquals(1L, itemsCompra.getCantidad());
        assertEquals(1L, itemsCompra.getIdCompra());
        assertEquals(2L, itemsCompra.getIdProducto());

    }
    @Test
    void deberiaFallarSinCantidadItemsProducto() {
        ItemTestDataBuilder itemTestDataBuilder = new ItemTestDataBuilder().validarCantidadItemsProducto(null);
        BasePrueba.assertThrows(() -> {
                    itemTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la cantidad del producto");

    }

    @Test
    void deberiaFallarSinIdCompraItem() {
        ItemTestDataBuilder itemTestDataBuilder = new ItemTestDataBuilder().validarIdCompraItem(null);
        BasePrueba.assertThrows(() -> {
                    itemTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe asignar la compra");

    }

    @Test
    void deberiaFallarSinIdProductoItem() {
        ItemTestDataBuilder itemTestDataBuilder = new ItemTestDataBuilder().validarIdProductoItem(null);
        BasePrueba.assertThrows(() -> {
                    itemTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe asignar el producto");

    }

}