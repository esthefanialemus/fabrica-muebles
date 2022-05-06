package com.ceiba.compra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompraTest {

    @Test
    void deberiaCrearcorrectamenteLaCompra() {
        LocalDateTime fechaCompra = LocalDateTime.now();
        LocalDateTime despachoCompra = LocalDateTime.now().plusDays(4);
        LocalDateTime entregaCompra = LocalDateTime.now().plusDays(4);
        Compra compra = new CompraTestDataBuilder().validarFechaCompra(fechaCompra).validarFechaDespacho(despachoCompra).validarFechaEntrega(entregaCompra).build();
        assertEquals(2L, compra.getId());
        assertEquals(1L, compra.getIdCliente());
        assertEquals(800.000, compra.getTotal());
        assertEquals(fechaCompra, compra.getFechaCompra());
        assertEquals(despachoCompra, compra.getFechaDespacho());
        assertEquals(entregaCompra, compra.getFechaEntrega());
    }

    @Test
    void deberiaFallarSinCliente() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarCliente(null);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el cliente a la compra");

    }


        @Test
        void deberiaFallarSinTotalCompra(){
            CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarTotalCompra(null);
            BasePrueba.assertThrows(() -> {
                        compraTestDataBuilder.build();

                    },
                    ExcepcionValorObligatorio.class, "Se debe ingresar el precio total de la compra");

        }

    @Test
    void deberiaFallarSinFechaCompra() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarFechaCompra(null);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de compra");

    }

    @Test
    void deberiaFallarSinFechaDespacho() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarFechaDespacho(null);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de despacho");

    }

    @Test
    void deberiaFallarSinFechaEntrega() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarFechaEntrega(null);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de entrega");

    }


}