package com.ceiba.producto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.manejador.ComandoProducto;
import com.ceiba.comando.manejador.producto.ManejadorActualizarProducto;
import com.ceiba.comando.manejador.producto.ManejadorCrearProducto;
import com.ceiba.comando.manejador.producto.ManejadorEliminarProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/producto")
@Api(tags = {"Controlador comando producto"})
public class ComandoControladorProducto {
    private final ManejadorCrearProducto manejadorCrearProducto;

    private final ManejadorActualizarProducto manejadorActualizarProducto;

    private ManejadorEliminarProducto manejadorEliminarProducto;

    @Autowired


    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto, ManejadorActualizarProducto manejadorActualizarProducto, ManejadorEliminarProducto manejadorEliminarProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorActualizarProducto = manejadorActualizarProducto;
        this.manejadorEliminarProducto = manejadorEliminarProducto;
    }

    @PostMapping
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Producto")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProducto.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Producto")
    public void actualizar(@RequestBody ComandoProducto comandoProducto,@PathVariable Long id) {
        comandoProducto.setId(id);
        manejadorActualizarProducto.ejecutar(comandoProducto);
    }
}
