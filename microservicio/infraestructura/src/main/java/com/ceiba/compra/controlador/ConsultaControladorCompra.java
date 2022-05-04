package com.ceiba.compra.controlador;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.consulta.compra.ManejadorListarCompra;
import com.ceiba.consulta.compra.ManejadorObtenerCompra;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/compra")
@Api(tags={"Controlador consulta compra"})
public class ConsultaControladorCompra {

	private final ManejadorListarCompra manejadorListarCompra;
    private final ManejadorObtenerCompra manejadorObtenerCompra;

    public ConsultaControladorCompra(ManejadorListarCompra manejadorListarCompra, ManejadorObtenerCompra manejadorObtenerCompra) {
        this.manejadorListarCompra = manejadorListarCompra;
        this.manejadorObtenerCompra = manejadorObtenerCompra;

    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener compra")
    public DtoCompra obtener(@PathVariable Long id) {
    	return this.manejadorObtenerCompra.ejecutar(id);
    }
    
   
    @GetMapping
    @ApiOperation("Listar compra")
    public List<DtoCompra> listar() {
        return this.manejadorListarCompra.ejecutar();
    }

}
