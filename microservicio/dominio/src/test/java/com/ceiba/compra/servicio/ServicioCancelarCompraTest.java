package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionCancelacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

class ServicioCancelarCompraTest {

    @Test
    @DisplayName("Deberia cancelar la compra")
    void deberiaCancelarLaCompra() {

        LocalDateTime fechaCompra = LocalDateTime.parse("2022-05-13T10:12:43.411");
        LocalDateTime fechaDespacho = LocalDateTime.parse("2022-05-10T09:12:43");
        LocalDateTime fechaEntrega = LocalDateTime.parse("2022-05-23T09:12:43");

        DtoCompra dtoCompra = new DtoCompra(1L, 2L, 1.000000, fechaCompra, fechaEntrega, fechaDespacho);

        // arrange
        Compra compra = new CompraTestDataBuilder().validarFechaDespacho(fechaDespacho).validarFechaEntrega(fechaEntrega).build();

        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        DaoCompra daoCompra = Mockito.mock(DaoCompra.class);
        Mockito.doNothing().when(repositorioCompra).cancelarCompra(compra);
        Mockito.when(daoCompra.listarCompraPorId(Mockito.anyLong())).thenReturn(dtoCompra);
        ServicioCancelarCompra servicioCancelarCompra = new ServicioCancelarCompra(daoCompra, repositorioCompra);
        // act - assert

        servicioCancelarCompra.ejecutar(compra);
        Mockito.verify(repositorioCompra, Mockito.times(1)).cancelarCompra(compra);
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valida la fecha de cancelacion")
    void deberiaLanzarUnaExepcionCuandoSeValidaLaFechaDeCancelacion() {

        LocalDateTime fechaCompra = LocalDateTime.parse("2022-05-25T10:12:43.411");
        LocalDateTime fechaDespacho = LocalDateTime.parse("2022-05-28T09:12:43");
        LocalDateTime fechaEntrega = LocalDateTime.parse("2022-06-02T09:12:43");

        DtoCompra dtoCompra = new DtoCompra(1L, 1L, 100.000, fechaCompra, fechaEntrega, fechaDespacho);

        Compra compra = new Compra(1L, 1L, 100.000, fechaCompra, fechaEntrega, fechaDespacho);
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        DaoCompra daoCompra = Mockito.mock(DaoCompra.class);
        Mockito.doNothing().when(repositorioCompra).cancelarCompra(compra);
        Mockito.when(daoCompra.listarCompraPorId(1L)).thenReturn(dtoCompra);
        ServicioCancelarCompra servicioCancelarCompra = new ServicioCancelarCompra(daoCompra, repositorioCompra);

        BasePrueba.assertThrows(() -> servicioCancelarCompra.ejecutar(compra),
                ExcepcionCancelacion.class, "La Compra solo puede ser cancelada antes de la fecha de despacho");
    }



}