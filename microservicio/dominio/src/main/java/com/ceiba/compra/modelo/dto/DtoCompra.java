package com.ceiba.compra.modelo.dto;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCompra {
    private Long id;
    private DtoCliente idCliente;
    private Double total;
    private LocalDateTime fechaCompra;

    private LocalDateTime fechaDespacho;

    private LocalDateTime fechaEntrega;



}
