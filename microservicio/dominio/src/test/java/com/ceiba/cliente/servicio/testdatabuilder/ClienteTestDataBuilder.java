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

    public Cliente build (){
        return new Cliente(id,nombre,apellido,identificacion,email,fechaCreacion);
    }
}
