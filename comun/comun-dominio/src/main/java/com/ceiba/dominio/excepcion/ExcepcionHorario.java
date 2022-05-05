package com.ceiba.dominio.excepcion;

public class ExcepcionHorario extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionHorario(String mensaje) {
        super(mensaje);
    }
}
