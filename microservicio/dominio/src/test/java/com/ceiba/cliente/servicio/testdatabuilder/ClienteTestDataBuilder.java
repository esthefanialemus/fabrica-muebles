package com.ceiba.cliente.servicio.testdatabuilder;


import com.ceiba.cliente.modelo.entidad.Cliente;

import java.time.LocalDateTime;

public class ClienteTestDataBuilder {
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String email;
    private LocalDateTime fechaCreacion;

    public ClienteTestDataBuilder() {
          id= 15684L;
          nombre="Esthef";
          apellido="Preciado";
          identificacion="1234";
          email="l@gmail.com";
          fechaCreacion=LocalDateTime.now();
    }

    public ClienteTestDataBuilder validarNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public ClienteTestDataBuilder validarApellido(String apellido){
        this.apellido=apellido;
        return this;
    }

    public ClienteTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ClienteTestDataBuilder validarIdentificacion(String identificacion){
        this.identificacion=identificacion;
        return this;
    }

    public ClienteTestDataBuilder validarEmail(String email){
        this.email=email;
        return this;
    }


    public Cliente build (){
        return new Cliente(id,nombre,apellido,identificacion,email,fechaCreacion);
    }


}
