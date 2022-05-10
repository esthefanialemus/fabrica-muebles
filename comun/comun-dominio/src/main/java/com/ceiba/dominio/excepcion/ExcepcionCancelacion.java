package com.ceiba.dominio.excepcion;

public class ExcepcionCancelacion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionCancelacion(String mensaje) {
        super(mensaje);
    }
}
