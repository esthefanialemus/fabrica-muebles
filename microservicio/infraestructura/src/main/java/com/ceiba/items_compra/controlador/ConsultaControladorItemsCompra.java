package com.ceiba.items_compra.controlador;

import com.ceiba.consulta.itemscompra.ManejadorListarDaoItemsCompra;
import com.ceiba.consulta.itemscompra.ManejadorListarItemsCompra;
import com.ceiba.consulta.itemscompra.ManejadorObtenerItemsCompra;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompra;
import com.ceiba.items_compra.modelo.dto.DtoItemsCompraConsulta;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/itemsCompra")
@Api(tags={"Controlador consulta itemsCompra"})
public class ConsultaControladorItemsCompra {

	private final ManejadorListarItemsCompra manejadorListarItemsCompra;
    private final ManejadorObtenerItemsCompra manejadorObtenerItemsCompra;

    private final ManejadorListarDaoItemsCompra manejadorListarDaoItemsCompra;



    public ConsultaControladorItemsCompra(ManejadorListarItemsCompra manejadorListarItemsCompra, ManejadorObtenerItemsCompra manejadorObtenerItemsCompra, ManejadorListarDaoItemsCompra manejadorListarDaoItemsCompra) {
        this.manejadorListarItemsCompra = manejadorListarItemsCompra;
        this.manejadorObtenerItemsCompra = manejadorObtenerItemsCompra;

        this.manejadorListarDaoItemsCompra = manejadorListarDaoItemsCompra;
    }
    
    @GetMapping(value = "/{id}")
    @ApiOperation("Obtener itemsCompra")
    public DtoItemsCompra obtener(@PathVariable Long id) {
    	return this.manejadorObtenerItemsCompra.ejecutar(id);
    }
    
   
    @GetMapping
    @ApiOperation("Listar itemsCompra")
    public List<DtoItemsCompra> listar() {
        return this.manejadorListarItemsCompra.ejecutar();
    }



    @GetMapping(value = "/daoItemsCompra/{id}")
    @ApiOperation("Listar daoitemsCompra")
    public List<DtoItemsCompraConsulta> listarDtoCompras(@PathVariable Long id) {
        return this.manejadorListarDaoItemsCompra.ejecutar(id);
    }

}
