package com.ceiba.usuario.cliente.entidad;

import lombok.Getter;

@Getter
public class Producto {
    private Long id;
    private Double valor;
    private String numeroPuesto;

    private String tipoComedor;





    public Producto(Long id, Double valor, String numeroPuesto, String tipoComedor) {

        this.id = id;
        this.valor = valor;
        this.numeroPuesto = numeroPuesto;
        this.tipoComedor = tipoComedor;



    }

}
