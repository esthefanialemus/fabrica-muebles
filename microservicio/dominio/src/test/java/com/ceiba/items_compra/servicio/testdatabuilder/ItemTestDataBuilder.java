package com.ceiba.items_compra.servicio.testdatabuilder;

import com.ceiba.items_compra.modelo.entidad.ItemsCompra;

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

    public ItemsCompra build (){
        return  new ItemsCompra(id,cantidad,idCompra,idProducto);
    }
}
