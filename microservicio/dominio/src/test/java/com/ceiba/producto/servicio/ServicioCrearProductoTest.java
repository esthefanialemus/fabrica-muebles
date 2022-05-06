package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.itemsCompra.modelo.entidad.ItemsCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.itemsCompra.servicio.ServicioCrearItemsCompra;
import com.ceiba.itemsCompra.servicio.testdatabuilder.ItemTestDataBuilder;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServicioCrearProductoTest {

    @Test
    @DisplayName("Deberia lanzar una excepcion cuando el producto  ya exista")
    void deberiaValidarExistenciaPreviaDelProducto(){

        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El Producto ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia crear el producto de manera correcta")
    void deberiaCrearElProductoCorrectamente(){

        // arrange
        Producto producto = new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioProducto.crear(producto)).thenReturn(1L);
        ServicioCrearProducto servicioCrearProducto = new ServicioCrearProducto(repositorioProducto);
        // act
        Long idProducto = servicioCrearProducto.ejecutar(producto);
        // - assert
        assertEquals(1L,idProducto);
        Mockito.verify(repositorioProducto, Mockito.times(1)).crear(producto);
    }







}