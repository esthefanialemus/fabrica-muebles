package com.ceiba.items_compra.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoItemsCompraConsultaSinCompra {
    //itemscompra
    private Long cantidad;


    //producto
    private Double valor;
    private String numeroPuesto;
    private String tipoComedor;



}
