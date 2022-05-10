package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioActualizarProductoTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el producto  ya exista")
    void deberiaValidarExistenciaPreviaDelProducto(){

        // arrange
        Producto producto = new ProductoTestDataBuilder().build();

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarProducto servicioActualizarProducto = new ServicioActualizarProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El Producto ya existe en el sistema");
    }





}