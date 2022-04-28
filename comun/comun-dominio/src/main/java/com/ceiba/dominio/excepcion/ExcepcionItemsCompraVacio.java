package com.ceiba.dominio.excepcion;

public class ExcepcionItemsCompraVacio  extends  RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionItemsCompraVacio(String mensaje) {
        super(mensaje);
    }
}
