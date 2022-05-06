package com.ceiba.producto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ProductoTestDataBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    void deberiaCrearCorrectamenteElProducto(){
        Producto producto = new ProductoTestDataBuilder().build();
        assertEquals(325L,producto.getId());
        assertEquals(1300.000,producto.getValor());
        assertEquals("6",producto.getNumeroPuesto());
        assertEquals("Vidrio",producto.getTipoComedor());


    }
    @Test
    void deberiaFallarSinTipoComedor(){
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().validarTipoComedor(null);
        BasePrueba.assertThrows(() -> {
                    productoTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de comedor");

    }
    @Test
    void deberiaFallarSinNumeroPuestos(){
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().validarNumeroPuestos(null);
        BasePrueba.assertThrows(() -> {
                    productoTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el numero de puestos");

    }



}