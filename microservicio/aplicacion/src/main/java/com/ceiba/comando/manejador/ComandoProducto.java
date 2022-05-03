package com.ceiba.comando.manejador;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoProducto {
    private Long id;
    private Double valor;
    private String numeroPuesto;
    private String tipoComedor;
}
