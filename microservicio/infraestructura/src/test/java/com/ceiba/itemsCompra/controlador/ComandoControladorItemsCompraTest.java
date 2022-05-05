package com.ceiba.itemsCompra.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoItemsCompra;
import com.ceiba.itemsCompra.servicio.ComandoItemsCompraTestDataBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorItemsCompra.class)
class ComandoControladorItemsCompraTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void crear() throws Exception {
        // arrange
        ComandoItemsCompra comandoItemsCompra = new ComandoItemsCompraTestDataBuilder().compraYProducto(1L,2L).build();

        // act - assert
        mocMvc.perform(post("/itemsCompra")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoItemsCompra)))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void eliminar() throws Exception {
        // arrange|
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/itemsCompra/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void actualizar() throws Exception {
        // arrange
        Long id = 1L;
        ComandoItemsCompra itemsCompra = new ComandoItemsCompraTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/itemsCompra/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(itemsCompra)))
                .andExpect(status().isOk());
    }
}