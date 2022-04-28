package com.ceiba.usuario.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoItemsCompra {

    private Long id;
    private Long idCompra;
    private Long idProducto;
    private Long cantidad;
}
