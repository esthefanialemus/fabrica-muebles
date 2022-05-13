package com.ceiba.compra.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionHorario;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompraTest {

    @Test
    @DisplayName("Deberia crear correctamente la compra")
    void deberiaCrearcorrectamenteLaCompra() {
        LocalDateTime fechaCompra = LocalDateTime.now();
        LocalDateTime despachoCompra = LocalDateTime.now().plusDays(3);
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
    @DisplayName("Deberia fallar la creacion sin el id del cliente")
    void deberiaFallarSinCliente() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarCliente(null);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el cliente a la compra");

    }


        @Test
        @DisplayName("Deberia fallar la creacion sin el total de la compra")
        void deberiaFallarSinTotalCompra(){
            CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarTotalCompra(null);
            BasePrueba.assertThrows(() -> {
                        compraTestDataBuilder.build();

                    },
                    ExcepcionValorObligatorio.class, "Se debe ingresar el precio total de la compra");

        }

    @Test
    @DisplayName("Deberia fallar la creacion sin la fecha de la compra")
    void deberiaFallarSinFechaCompra() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarFechaCompra(null);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de compra");

    }

    @Test
    @DisplayName("Deberia fallar la creacion sin la fecha de despacho del cliente")
    void deberiaFallarSinFechaDespacho() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarFechaDespacho(null);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha despacho de despacho");

    }


    @Test
    void deberiaFallarSinFechaEntrega() {
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().validarFechaEntrega(null);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha entrega de entrega");

    }

    @Test
    @DisplayName("Deberia fallar fuera del horario habil")
    void deberiaFallarFueraDelHoraioHabil() {
        LocalDateTime fecha = LocalDateTime.parse("2022-05-14T22:12:43");
        CompraTestDataBuilder compraTestDataBuilder = new CompraTestDataBuilder().verificarHorarioDeAtencion(fecha);
        BasePrueba.assertThrows(() -> {
                    compraTestDataBuilder.build();

                },
                ExcepcionHorario.class, "la Compra no se puede realizar fuera de nuestro horario de atencion");

    }


    @Test
    @DisplayName("Deberia alertar si es fin de semana la compra")

    void deberiaValidarSiEsFinDeSemana(){
        LocalDateTime fecha = LocalDateTime.parse("2022-05-14T10:12:43");
        //Arrange
        Compra compra = new CompraTestDataBuilder().validarId(1L).validarCliente(1L).validarTotalCompra(100.000).validarFechaCompra(fecha).validarFechaEntrega(fecha.plusDays(6)).validarFechaDespacho(fecha.plusDays(3)).build();
        assertEquals(true,compra.verificarFinDeSemana(compra.getFechaCompra()));
        //act-assert
    }
    @Test
    @DisplayName("Deberia cuando no es fin de semana la compra")

    void deberiaValidarNoFinDeSemana(){
        LocalDateTime fecha = LocalDateTime.parse("2022-05-13T10:12:43");
        //Arrange
        Compra compra = new CompraTestDataBuilder().validarId(1L).validarCliente(1L).validarTotalCompra(100.000).validarFechaCompra(fecha).validarFechaEntrega(fecha.plusDays(6)).validarFechaDespacho(fecha.plusDays(3)).build();
        assertEquals(false,compra.verificarFinDeSemana(compra.getFechaCompra()));
        //act-assert
    }



    @Test
    @DisplayName("Deberia alertar si es fin de semana la compra")

    void validarRecargoFinde(){
        LocalDateTime fecha = LocalDateTime.parse("2022-05-14T10:12:43");
        //Arrange
        Compra compra = new CompraTestDataBuilder().validarId(1L).validarCliente(1L).validarTotalCompra(100.000).validarFechaCompra(fecha).validarFechaEntrega(fecha.plusDays(6)).validarFechaDespacho(fecha.plusDays(3)).build();
        assertEquals(24.000,Compra.asignarRecargoFinDeSemana(compra.getFechaCompra(),compra.getTotal()));
        //act-assert
    }



}