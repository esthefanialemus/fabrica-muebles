package com.ceiba.cliente.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_LOS_NOMBRES_DEL_CLIENTE = "Se debe ingresar los nombres del cliente";
    private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS_DEL_CLIENTE = "Se debe ingresar los apellidos del cliente";
    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE = "Se debe ingresar la identificaci\u00f3n del cliente";
    private static final String SE_DEBE_INGRESAR_EL_EMAIL = "Se debe ingresar el email del cliente";

    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String email;


    public Cliente(Long id, String nombre, String apellido, String identificacion, String email) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_LOS_NOMBRES_DEL_CLIENTE);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_LOS_APELLIDOS_DEL_CLIENTE);
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE);
        validarObligatorio(email, SE_DEBE_INGRESAR_EL_EMAIL);

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.email = email;
    }
}
