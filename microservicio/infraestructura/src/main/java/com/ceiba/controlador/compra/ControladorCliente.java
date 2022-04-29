package com.ceiba.controlador.compra;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.servicio.ServicioAplicacionGuardarCliente;
import com.ceiba.servicio.ServicioAplicacionListarCliente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ControladorCliente {
    private final ServicioAplicacionListarCliente servicioAplicacionListarClientes;
    private final ServicioAplicacionGuardarCliente servicioAplicacionGuardarClientes;


    public ControladorCliente(ServicioAplicacionListarCliente servicioAplicacionListarClientes, ServicioAplicacionGuardarCliente servicioAplicacionGuardarClientes) {
        this.servicioAplicacionListarClientes = servicioAplicacionListarClientes;
        this.servicioAplicacionGuardarClientes = servicioAplicacionGuardarClientes;
    }

    @RequestMapping("/clientes")
    public List<DtoCliente> listar() {
        return this.servicioAplicacionListarClientes.ejecutar();
    }

    @PostMapping("/clientes")
    public void guardar(@RequestBody Map<String, Object> json) {
        this.servicioAplicacionGuardarClientes.ejecutar(Long.valueOf(obtenerValor(json, "id")),
                obtenerValor(json, "nombre"), obtenerValor(json, "apellido"), obtenerValor(json, "identificacion"), obtenerValor(json, "email"));
    }

    private String obtenerValor(Map<String, Object> json, String id) {
        return  json.get(id).toString();
    }


}
