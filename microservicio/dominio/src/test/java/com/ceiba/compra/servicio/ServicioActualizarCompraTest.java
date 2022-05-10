package com.ceiba.compra.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioActualizarCompraTest {

    @Test
    @DisplayName("Deberia actualizar la compra")
    void deberiaActualizarLaCompra(){

        LocalDateTime fecha =LocalDateTime.parse("2022-05-18T09:12:43");
        // arrange
        Compra compra = new CompraTestDataBuilder().validarFechaCompra(fecha).validarCliente(1L).build();

        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);
        Mockito.when(repositorioCompra.existe(fecha,1L)).thenReturn(true);
        ServicioActualizarCompra servicioActualizarCompra = new ServicioActualizarCompra(repositorioCompra);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCompra.ejecutar(compra), ExcepcionDuplicidad.class,"La Compra ya existe en el sistema");
    }





}