package com.ceiba.items_compra.controlador;

import com.ceiba.ApplicationMock;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ConsultaControladorItemsCompra.class)
class ConsultaControladorItemsCompraTest {

    @Autowired
    private MockMvc mocMvc;


    /**
    @Test
    void obtener() throws Exception {
        Long id = 1L;
        mocMvc.perform(get("/itemsCompra/{id}", id).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(jsonPath("$.idCompra", is("1")));

    }
     */

    /**
    @Test
    void listar() throws Exception {
        // arrange

        // act - assert
        mocMvc.perform(get("/itemsCompra").contentType(MediaType.APPLICATION_JSON)).andExpect(status().is4xxClientError());

    }
    */
}