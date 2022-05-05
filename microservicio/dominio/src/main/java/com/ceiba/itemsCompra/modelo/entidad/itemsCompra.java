package com.ceiba.itemsCompra.modelo.entidad;


import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class itemsCompra {

    private static final String SE_DEBE_INGRESAR_LA_CANTIDAD_DEL_PRODUCTO = "Se debe ingresar la cantidad del producto";
    private static final String SE_DEBE_ASIGNAR_COMPRA = "Se debe asignar la compra";

    private static final String SE_DEBE_ASIGNAR_PRODUCTO = "Se debe asignar el producto";


    private Long id;
    private Long cantidad;
    private Long idCompra;

    private Long idProducto;


    public itemsCompra(Long id, Long cantidad, Long idCompra, Long idProducto) {


        validarObligatorio(cantidad, SE_DEBE_INGRESAR_LA_CANTIDAD_DEL_PRODUCTO);
        validarObligatorio(idCompra, SE_DEBE_ASIGNAR_COMPRA);
        validarObligatorio(idProducto, SE_DEBE_ASIGNAR_PRODUCTO);


        this.id = id;
        this.cantidad = cantidad;
        this.idCompra = idCompra;
        this.idProducto = idProducto;
    }

}
