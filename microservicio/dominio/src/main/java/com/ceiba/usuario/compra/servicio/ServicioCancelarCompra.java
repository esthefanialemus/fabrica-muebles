package com.ceiba.usuario.compra.servicio;

import com.ceiba.usuario.compra.modelo.dto.DtoCompra;
import com.ceiba.usuario.compra.puerto.dao.DaoCompra;
import com.ceiba.usuario.compra.puerto.repositorio.RepositorioCompra;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioCancelarCompra {
    private final RepositorioCompra repositorioCompra;

    private final DaoCompra daoCompra;

    public ServicioCancelarCompra(RepositorioCompra repositorioCompra, DaoCompra daoCompra) {
        this.repositorioCompra = repositorioCompra;
        this.daoCompra = daoCompra;
    }

    public void ejecutar(Long idCompra){
        DtoCompra dtoCompra = daoCompra.listarCompraPorId(idCompra);

        if(validarCancelacionCompra( dtoCompra.getFechaDespacho(),  dtoCompra.getFechaDespacho())) {

            this.repositorioCompra.cancelarCompra(idCompra);

        }


    }

    private boolean validarCancelacionCompra(LocalDateTime fechaDespacho, LocalDateTime fechaEntrega )
    {
        LocalDate fechaActual= LocalDate.now();

        if(( fechaActual.isEqual(fechaDespacho.toLocalDate()) || fechaActual.isAfter(fechaDespacho.toLocalDate())  ) && fechaActual.isBefore(fechaEntrega.toLocalDate()) ){
            return  true;
        }else{
            return  false;
        }
    }




}
