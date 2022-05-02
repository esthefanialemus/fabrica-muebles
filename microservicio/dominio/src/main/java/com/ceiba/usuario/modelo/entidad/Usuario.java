package com.ceiba.usuario.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_USERNAME = "Se debe ingresar el username";
    private static final String SE_DEBE_INGRESAR_PASSWORD = "Se debe ingresar la contraseña";

    private Long id;
    private String clave;
    private String nombre
            ;

    public Usuario(Long id, String clave, String nombre) {
        validarObligatorio(clave, SE_DEBE_INGRESAR_PASSWORD);
        validarObligatorio(nombre, SE_DEBE_INGRESAR_USERNAME);


        this.id = id;
        this.clave = clave;
        this.nombre = nombre;

    }
}
