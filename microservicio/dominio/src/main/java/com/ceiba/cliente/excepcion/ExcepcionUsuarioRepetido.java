package com.ceiba.cliente.excepcion;

public class ExcepcionUsuarioRepetido  extends  RuntimeException{


    private static final long serialVersionUID = 1L;

    public ExcepcionUsuarioRepetido(String mensaje) {
        super(mensaje);
    }
}
