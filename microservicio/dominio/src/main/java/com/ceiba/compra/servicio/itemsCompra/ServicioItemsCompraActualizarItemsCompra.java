package com.ceiba.compra.servicio.itemsCompra;

import com.ceiba.compra.modelo.entidad.ItemsCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioItemsCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionItemsCompraVacio;

public class ServicioItemsCompraActualizarItemsCompra {
    private static final String ITEMS_COMPRA_VACIO = "La cantidad de items no puede ser cero";

    private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";

    private final RepositorioItemsCompra repositorioItemsCompra;



    public ServicioItemsCompraActualizarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
        this.repositorioItemsCompra = repositorioItemsCompra;
    }

    public Long ejecutar (ItemsCompra itemsCompra){

        validarExistenciaPrevia(itemsCompra);
        actualizarItemCompra(itemsCompra, itemsCompra.getCantidad());

        return this.repositorioItemsCompra.crear(itemsCompra);
    }

    private void validarExistenciaPrevia(ItemsCompra itemsCompra) {
        boolean existe = this.repositorioItemsCompra.existeExcluyendoId(itemsCompra.getId(),itemsCompra.getIdCompra());
        if (existe) {
            throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void actualizarItemCompra(ItemsCompra itemsCompra, Long cantidadActualizar) {
        boolean existe = this.repositorioItemsCompra.existeExcluyendoId(itemsCompra.getId(), itemsCompra.getIdCompra());

      if(existe)
      {
          if  ( cantidadActualizar  >= 1 )
          {
              itemsCompra.setCantidad(cantidadActualizar);
          }else{
              throw  new ExcepcionItemsCompraVacio(ITEMS_COMPRA_VACIO);
          }
      }
    }
}
