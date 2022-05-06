package com.ceiba.cliente.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    @DisplayName("Deberia crear  correctamente al cliente")
    void deberiaCrearCorrectamenteElCliente(){
        Cliente cliente = new ClienteTestDataBuilder().build();
        assertEquals(15684L,cliente.getId());
        assertEquals("Esthef",cliente.getNombre());
        assertEquals("Preciado",cliente.getApellido());
        assertEquals("1234",cliente.getIdentificacion());
        assertEquals("l@gmail.com",cliente.getEmail());

    }

    @Test
    @DisplayName("Deberia fallar la creacion sin el nombre del cliente")
    void deberiaFallarSinNombre(){
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().validarNombre(null);
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de usuario");

    }

    @Test
    @DisplayName("Deberia fallar la creacion sin el apellido del cliente")
    void deberiaFallarSinApellido(){
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().validarApellido(null);
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar los apellidos del cliente");

    }

    @Test
    @DisplayName("Deberia fallar la creacion sin la identificacion del cliente")
    void deberiaFallarSinIdentificacion(){
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().validarIdentificacion(null);
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la identificacion del cliente");

    }

    @Test
    @DisplayName("Deberia fallar la creacion sin el email del cliente")
    void deberiaFallarSinEmail(){
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().validarEmail(null);
        BasePrueba.assertThrows(() -> {
                    clienteTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el email del cliente");

    }




}