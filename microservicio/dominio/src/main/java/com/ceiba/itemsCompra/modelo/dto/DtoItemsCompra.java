package com.ceiba.itemsCompra.modelo.dto;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.producto.modelo.dto.DtoProducto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoItemsCompra {
    private Long id;
    private Long cantidad;
    private DtoCompra idCompra;
    private DtoProducto idProducto;


}
