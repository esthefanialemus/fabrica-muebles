package com.ceiba.controlador.usuario;

import com.ceiba.ApplicationMock;
import com.ceiba.comando.ComandoUsuario;
import com.ceiba.servicio.testdatabuilder.ComandoUsuarioTestDataBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorUsuario.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorUsuarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @org.junit.jupiter.api.Test
    @DisplayName("Deberia crear un usuario")
    void usuarioCrear() throws Exception {
        // arrange
        ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Deberia eliminar un usuario")
    void usuarioEliminar() throws Exception {
        // arrange
        Long id = 1L;

        // act - assert
        mocMvc.perform(delete("/usuario/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Deberia actualizar un usuario")
    void usuarioActualizar() throws Exception {
        Long id = 1L;
        ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/usuario/{id}",id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(usuario)))
                .andExpect(status().isOk());
    }
}