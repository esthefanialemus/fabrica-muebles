package com.ceiba.producto.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class Producto {


    private static final String SE_DEBE_INGRESAR_EL_NUMERO_DE_PUESTO = "Se debe ingresar el numero de puestos";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_COMEDOR = "Se debe ingresar el tipo de comedor";
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
