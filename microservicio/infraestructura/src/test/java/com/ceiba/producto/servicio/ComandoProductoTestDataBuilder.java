package com.ceiba.producto.servicio;

import com.ceiba.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {
    private Long id;
    private Double valor;
    private String numeroPuesto;
    private String tipoComedor;

    public ComandoProductoTestDataBuilder() {
        id=3L;
        valor=1500.000;
        numeroPuesto="6";
        tipoComedor="Tapizado";
    }

    public ComandoProducto build(){
       return new ComandoProducto(id,valor,numeroPuesto,tipoComedor);
    }

}
