package com.ceiba.consulta.itemscompra;

import com.ceiba.itemsCompra.modelo.dto.DtoItemsCompra;
import com.ceiba.itemsCompra.puerto.dao.DaoItemsCompra;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarItemsCompra {

    private final DaoItemsCompra daoItemsCompra;

    public ManejadorListarItemsCompra(DaoItemsCompra daoItemsCompra){
        this.daoItemsCompra = daoItemsCompra;
    }

    public List<DtoItemsCompra> ejecutar(){ return this.daoItemsCompra.listar(); }
}
