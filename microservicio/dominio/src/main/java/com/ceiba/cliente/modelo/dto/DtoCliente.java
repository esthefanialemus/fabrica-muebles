package com.ceiba.cliente.modelo.dto;


import java.time.LocalDateTime;

public class DtoCliente {
    private Long id;
    private String nombre;
    private String apellido;
    private String identificacion;
    private String email;
    private LocalDateTime fechaCreacion;



    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public DtoCliente(Long id) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.identificacion = identificacion;
        this.email = email;
        this.fechaCreacion = fechaCreacion;
    }
}
