package com.ceiba.compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private Long idCliente;
    private Double total;
    private LocalDateTime fechaCompra;

    private LocalDateTime fechaDespacho;

    private LocalDateTime fechaEntrega;
}
