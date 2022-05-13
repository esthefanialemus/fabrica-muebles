package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.items_compra.servicio.testdatabuilder.ItemTestDataBuilder;
import com.ceiba.producto.modelo.entidad.Producto;

public class ProductoTestDataBuilder {

    private Long id;
    private Double valor;
    private String numeroPuesto;
    private String tipoComedor;

    public ProductoTestDataBuilder() {
       id=325L;
       valor=1300.000;
       numeroPuesto="6";
       tipoComedor="Vidrio";

    }

    public ProductoTestDataBuilder validarId(Long id){
        this.id=id;
        return this;
    }
    public ProductoTestDataBuilder validarNumeroPuestos(String numeroPuesto){
        this.numeroPuesto=numeroPuesto;
        return this;

    }

    public ProductoTestDataBuilder validarTipoComedor(String tipoComedor){
        this.tipoComedor=tipoComedor;
        return this;

    }



    public Producto build(){
        return new Producto(id,valor,numeroPuesto,tipoComedor);
    }
}
