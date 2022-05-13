package com.ceiba.producto.controlador;

import com.ceiba.consulta.producto.ManejadorListarProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Api(tags = {"Controlador consulta producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProducto manejadorListarProducto;

    public ConsultaControladorProducto(ManejadorListarProducto manejadorListarProducto) {
        this.manejadorListarProducto = manejadorListarProducto;
    }

    @GetMapping
    @ApiOperation("Listar Productos")
    public List<DtoProducto> listar() {
        System.out.println( this.manejadorListarProducto.ejecutar());
        return this.manejadorListarProducto.ejecutar();

    }



}
