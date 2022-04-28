package com.ceiba.consulta.itemsCompra;

import com.ceiba.compra.modelo.dto.DtoItemsCompra;
import com.ceiba.compra.puerto.dao.DaoItemsCompra;
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
