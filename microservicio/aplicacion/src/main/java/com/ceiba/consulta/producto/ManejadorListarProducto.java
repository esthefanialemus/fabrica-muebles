package com.ceiba.consulta.producto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProducto {

    private final DaoProducto daoProducto;


    public ManejadorListarProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public List<DtoProducto> ejecutar (){
        return  this.daoProducto.listar();
    }
}
