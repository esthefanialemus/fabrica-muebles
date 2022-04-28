package com.ceiba.usuario.compra.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemsCompra {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creacion";

    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_MUEBLE = "Se debe ingresar el tipo de mueble";

    private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_COMEDOR = "Se debe ingresar el tipo de comedor ";


    private Long id;

    private Long idCompra;

    private Long idProducto;

    private Long cantidad;



}
