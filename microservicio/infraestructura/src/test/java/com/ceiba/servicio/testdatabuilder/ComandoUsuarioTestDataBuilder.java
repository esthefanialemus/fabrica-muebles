package com.ceiba.servicio.testdatabuilder;

import com.ceiba.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String clave;


    public ComandoUsuarioTestDataBuilder() {
        id=2L;
        nombre = "Esthefania";
        clave = "12345";

    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id, nombre, clave);
    }
}
