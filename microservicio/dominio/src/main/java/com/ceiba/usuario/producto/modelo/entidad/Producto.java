package com.ceiba.usuario.producto.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

public class Producto {

    private Long id;
    private Double valor;
    private String numeroPuestos;
    private String tipoComedor;

    private static final String SE_DEBE_INGRESAR_EL_TIPO_COMEDOR = "Se debe ingresar el tipo de comedor";
    private static final String SE_DEBE_INGRESAR_EL_NUMERO_PUESTOS = "Se debe ingresar el numero de puestos";


    public Producto(Long id, Double valor, String numeroPuestos, String tipoComedor) {
        validarObligatorio(numeroPuestos, SE_DEBE_INGRESAR_EL_NUMERO_PUESTOS);
        validarObligatorio(tipoComedor, SE_DEBE_INGRESAR_EL_TIPO_COMEDOR);



        this.id = id;
        this.valor = valor;
        this.numeroPuestos = numeroPuestos;
        this.tipoComedor = tipoComedor;
    }
}
