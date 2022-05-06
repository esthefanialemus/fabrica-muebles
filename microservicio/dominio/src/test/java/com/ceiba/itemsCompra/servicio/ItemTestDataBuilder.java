package com.ceiba.itemsCompra.servicio;

import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.itemsCompra.modelo.entidad.itemsCompra;

public class ItemTestDataBuilder {

    private Long id;
    private Long cantidad;
    private Long idCompra;

    private Long idProducto;

    public ItemTestDataBuilder() {
       id=6L;
       cantidad=1L;
       idCompra=1L;
       idProducto=2L;

    }

    public ItemTestDataBuilder validarCantidadItemsProducto(Long cantidad){
        this.cantidad=cantidad;
        return this;
    }

    public ItemTestDataBuilder validarIdCompraItem(Long idCompra){
        this.idCompra=idCompra;
        return this;
    }

    public ItemTestDataBuilder validarIdProductoItem(Long idProducto){
        this.idProducto=idProducto;
        return this;
    }

    public itemsCompra build (){
        return  new itemsCompra(id,cantidad,idCompra,idProducto);
    }
}
