package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearClienteTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el cliente ya exista")
    void deberiaValidarExistenciaPreviaDelCliente(){

        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class,"El Cliente ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear al cliente de manera correcta")
    void deberiaCrearAClienteCorrectamente(){

        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn(1L);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        // act
        Long idCliente = servicioCrearCliente.ejecutar(cliente);
        // - assert
        assertEquals(1L,idCliente);
        Mockito.verify(repositorioCliente, Mockito.times(1)).crear(cliente);
    }







}