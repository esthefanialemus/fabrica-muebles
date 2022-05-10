package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioEliminarProductoTest {

    @Test
    @DisplayName("Deberia eliminar el producto llamando al repositorio")
    void deberiaValidarExistenciaPreviaDelProducto(){

        RepositorioProducto repositorioProducto = Mockito.mock(RepositorioProducto.class);
        ServicioEliminarProducto servicioEliminarProducto = new ServicioEliminarProducto(repositorioProducto);

        servicioEliminarProducto.ejecutar(1l);

        Mockito.verify(repositorioProducto, Mockito.times(1)).eliminar(1l);
    }





}