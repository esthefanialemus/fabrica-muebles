package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoUsuario {

    private Long id;
    private String clave;
    private String nombre;
}
