package com.ceiba.usuario.modelo.entidad;

import com.ceiba.usuario.modelo.util.EnumNumeroPuesto;
import com.ceiba.usuario.modelo.util.EnumTipoComedor;
import lombok.Getter;

@Getter
public class Producto {
    private Long id;
    private EnumNumeroPuesto enumNumeroPuesto;

    private EnumTipoComedor enumTipoComedor;


    private Long valor;


    public Producto(Long id, EnumNumeroPuesto enumNumeroPuesto, Long valor, EnumTipoComedor enumTipoComedor) {

        this.id = id;
        this.enumNumeroPuesto = enumNumeroPuesto;
        this.enumTipoComedor= enumTipoComedor;
        this.valor = valor;


    }

}
