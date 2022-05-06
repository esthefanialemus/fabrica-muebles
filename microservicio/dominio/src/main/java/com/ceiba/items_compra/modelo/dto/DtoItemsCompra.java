package com.ceiba.items_compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoItemsCompra {
    private Long id;
    private Long cantidad;
    private Long idCompra;
    private Long idProducto;


}
