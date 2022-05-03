package com.ceiba.consulta.producto;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerProducto {

    private final DaoProducto daoProducto;


    public ManejadorObtenerProducto(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public DtoProducto ejecutar (Long id){
        return this.daoProducto.obtener(id);
    }
}
