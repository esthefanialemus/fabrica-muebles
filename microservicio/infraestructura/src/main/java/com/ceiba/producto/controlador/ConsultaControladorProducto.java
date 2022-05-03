package com.ceiba.producto.controlador;

import com.ceiba.consulta.producto.ManejadorListarProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@Api(tags = {"Controlador consulta producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProducto manejadorListarProducto;

    public ConsultaControladorProducto(ManejadorListarProducto manejadorListarProducto) {
        this.manejadorListarProducto = manejadorListarProducto;
    }

    @GetMapping
    @ApiOperation("Listar Productos")
    public List<DtoProducto> listar() {
        return this.manejadorListarProducto.ejecutar();
    }



}
