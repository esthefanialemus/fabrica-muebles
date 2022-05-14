package com.ceiba.cliente.controlador;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.consulta.cliente.ManejadorListarCliente;
import com.ceiba.consulta.cliente.ManejadorObtenerCliente;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Api(tags={"Controlador consulta cliente"})
public class ConsultaControladorCliente {

	private final ManejadorListarCliente manejadorListarCliente;

    public ConsultaControladorCliente(ManejadorListarCliente manejadorListarCliente) {
        this.manejadorListarCliente = manejadorListarCliente;

    }
    

    @GetMapping
    @ApiOperation("Listar cliente")
    public List<DtoCliente> listarClientes() {
        return this.manejadorListarCliente.ejecutar();
    }

}
