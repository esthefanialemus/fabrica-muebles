package com.ceiba.producto.servicio;

import com.ceiba.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {
    private Long id;
    private Double valor;
    private String numeroPuesto;
    private String tipoComedor;

    public ComandoProductoTestDataBuilder() {
        id=2L;
        valor=500.000;
        numeroPuesto="4";
        tipoComedor="Madera";
    }

    public ComandoProducto build(){
       return new ComandoProducto(id,valor,numeroPuesto,tipoComedor);
    }

}
