package com.ceiba.testdatabuilder;


import com.ceiba.usuario.modelo.entidad.Usuario;

public class UsuarioTestDataBuilder {


	private Long id;
	private String clave;
	private String nombre;
	
    public UsuarioTestDataBuilder() {
    	nombre = "1234";
    	clave = "1234";

        
    }

    public UsuarioTestDataBuilder conPassword(String clave) {
        this.clave = clave;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id, clave, nombre);
    }
}
