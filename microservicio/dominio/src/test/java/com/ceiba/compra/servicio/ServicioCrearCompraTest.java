package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionHorario;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearCompraTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando la compra ya exista")
    void deberiaValidarExistenciaPreviaDeLaCompra(){

        LocalDateTime fecha =LocalDateTime.parse("2022-05-18T09:12:43");
        // arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existe(fecha,1L)).thenReturn(true);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCompra.ejecutar(compra), ExcepcionDuplicidad.class,"la Compra ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear la compra de manera correcta")
    void deberiaCrearLaCompraCorrectamente(){

        LocalDateTime fecha = LocalDateTime.parse("2022-05-18T09:12:43");
        // arrange
        Compra compra = new CompraTestDataBuilder().build();
        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existe(fecha,1L)).thenReturn(false);
        Mockito.when(repositorioCompra.crear(compra)).thenReturn(1L);
        ServicioCrearCompra servicioCrearCompra = new ServicioCrearCompra(repositorioCompra);
        // act
        Long idCompra = servicioCrearCompra.ejecutar(compra);
        // - assert
        assertEquals(1L,idCompra);
        Mockito.verify(repositorioCompra, Mockito.times(1)).crear(compra);
    }









}