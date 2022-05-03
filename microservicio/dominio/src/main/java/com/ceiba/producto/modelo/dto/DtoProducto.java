package com.ceiba.producto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoProducto {

    private Long id;
    private Double valor;
    private String numeroPuesto;
    private String tipoComedor;


}
