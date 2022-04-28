package com.ceiba.compra.modelo.dto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoItemsCompra {

    private Long id;
    private DtoCompra idCompra;
    private DtoProducto idProducto;
    private Long cantidad;
}
