package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.compra.servicio.testdatabuilder.CompraTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

class ServicioEliminarCompraTest {

    @Test
    @DisplayName("Deberia eliminar la compra")
    void deberiaEliminarLaCompra(){


        RepositorioCompra repositorioCompra = Mockito.mock(RepositorioCompra.class);

        ServicioEliminarCompra servicioEliminarCompra = new ServicioEliminarCompra(repositorioCompra);
        // act - assert

        servicioEliminarCompra.ejecutar(1L);
        Mockito.verify(repositorioCompra,Mockito.times(1)).eliminar(1L);
    }





}