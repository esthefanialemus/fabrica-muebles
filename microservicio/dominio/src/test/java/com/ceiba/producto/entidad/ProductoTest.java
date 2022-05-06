package com.ceiba.producto.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductoTest {

    @Test
    @DisplayName("Deberia crear correctamente el producto")
    void deberiaCrearCorrectamenteElProducto(){
        Producto producto = new ProductoTestDataBuilder().build();
        assertEquals(325L,producto.getId());
        assertEquals(1300.000,producto.getValor());
        assertEquals("6",producto.getNumeroPuesto());
        assertEquals("Vidrio",producto.getTipoComedor());


    }
    @Test
    @DisplayName("Deberia fallar la creacion sin el tipo comedor del producto")
    void deberiaFallarSinTipoComedor(){
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().validarTipoComedor(null);
        BasePrueba.assertThrows(() -> {
                    productoTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de comedor");

    }
    @Test
    @DisplayName("Deberia fallar la creacion sin el numero de puestos del producto")
    void deberiaFallarSinNumeroPuestos(){
        ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().validarNumeroPuestos(null);
        BasePrueba.assertThrows(() -> {
                    productoTestDataBuilder.build();

                },
                ExcepcionValorObligatorio.class, "Se debe ingresar el numero de puestos");

    }



}