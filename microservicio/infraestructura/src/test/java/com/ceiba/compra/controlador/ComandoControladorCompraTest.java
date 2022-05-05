package com.ceiba.compra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.cliente.servicio.ComandoClienteTestDataBuilder;
import com.ceiba.comando.ComandoCliente;
import com.ceiba.comando.ComandoCompra;
import com.ceiba.compra.servicio.ComandoCompraTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorCompra.class)
class ComandoControladorCompraTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void crear() throws Exception {

        // arrange
        ComandoCompra comandoCompra = new ComandoCompraTestDataBuilder().conFechaEntregaCompraYCliente(2L, LocalDateTime.now().plusDays(1),LocalDateTime.now().plusDays(2)).build();

        // act - assert
        mocMvc.perform(post("/compra")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCompra)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
    }


    @Test
    void actualizar() throws Exception {


        // arrange


        Long id = 2L;
        ComandoCompra compra = new ComandoCompraTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/compra/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(compra)))
                .andExpect(status().isOk());
    }

    @Test
    void eliminar() throws Exception {

        // arrange|
        Long id = 1L;

        // act - assert
        mocMvc.perform(delete("/compra/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}