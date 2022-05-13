package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Cliente {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";

     private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_LOS_APELLIDOS_DEL_CLIENTE = "Se debe ingresar los apellidos del cliente";
    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE = "Se debe ingresar la identificacion del cliente";
    private static final String SE_DEBE_INGRESAR_EL_EMAIL = "Se debe ingresar el email del cliente";

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_CREACION = "Se debe ingresar la fecha de creacion del cliente";


    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String email;
    private LocalDateTime fechaCreacion;

    public Cliente(Long id, String nombre, String apellido, String identificacion, String email, LocalDateTime fechaCreacion) {

        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(apellido, SE_DEBE_INGRESAR_LOS_APELLIDOS_DEL_CLIENTE);
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION_DEL_CLIENTE);
        validarObligatorio(email, SE_DEBE_INGRESAR_EL_EMAIL);
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
    }


}
