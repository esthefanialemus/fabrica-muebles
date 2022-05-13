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

class ServicioActualizarClienteTest {

    @Test
    @DisplayName("Deberia actualizar y lanzar una excepcion cuando el cliente ya exista ")
    void deberiaValidarExistenciaPrevia(){

        // arrange
        Cliente cliente = new ClienteTestDataBuilder().conIdentificacion("1094972643").build();

        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe("1094972643")).thenReturn(true);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class,"El Cliente ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().conId(123L).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(false);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        // act
        servicioActualizarCliente.ejecutar(cliente);
        //assert
        Mockito.verify(repositorioCliente,Mockito.times(1)).actualizar(cliente);
    }





}