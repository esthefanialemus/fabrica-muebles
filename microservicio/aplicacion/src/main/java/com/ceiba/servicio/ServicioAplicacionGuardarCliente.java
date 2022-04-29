package com.ceiba.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioGuardarCliente;

public class ServicioAplicacionGuardarCliente {
    private final ServicioGuardarCliente servicioGuardarCliente;

    public ServicioAplicacionGuardarCliente(ServicioGuardarCliente servicioGuardarCliente) {
        this.servicioGuardarCliente = servicioGuardarCliente;
    }

    public void ejecutar(Long id, String nombre, String apellido, String identificacion, String email) {
        this.servicioGuardarCliente.guardar(new Cliente(id, nombre, apellido, identificacion, email));
    }
}
