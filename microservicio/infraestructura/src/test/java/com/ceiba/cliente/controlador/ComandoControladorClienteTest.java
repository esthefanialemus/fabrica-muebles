package com.ceiba.cliente.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoCliente;
import com.ceiba.cliente.servicio.ComandoClienteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorCliente.class)
public class ComandoControladorClienteTest  {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;


    @Test
    void crear() throws  Exception{
        // arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/cliente")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk());
    }

    @Test
    void eliminar() throws  Exception{
        // arrange|
        Long id = 3L;

        // act - assert
        mocMvc.perform(delete("/cliente/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void actualizar() throws Exception {
        // arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/cliente/{id}",3)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk());
    }
}