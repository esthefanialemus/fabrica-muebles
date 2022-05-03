package com.ceiba.comando.manejador;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ComandoProducto {
    private Long id;
    private Double valor;
    private String numeroPuesto;
    private String tipoComedor;
}
