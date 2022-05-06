package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deberiaCrearCorrectamenteElCliente(){
        Cliente cliente = new ClienteTestDataBuilder().build();
        assertEquals(15684L,cliente.getId());
        assertEquals("Esthef",cliente.getNombre());
        assertEquals("Preciado",cliente.getApellido());
        assertEquals("1234",cliente.getIdentificacion());
        assertEquals("l@gmail.com",cliente.getEmail());

    }

    @Test
    void deberiaFallarSinNombre(){
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().validarNombre(null);
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");

    }

    @Test
    void deberiaFallarSinApellido(){
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().validarApellido(null);
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar los apellidos del cliente");

    }

    @Test
    void deberiaFallarSinIdentificacion(){
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().validarIdentificacion(null);
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion del cliente");

    }

    @Test
    void deberiaFallarSinEmail(){
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().validarEmail(null);
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el email del cliente");

    }




}