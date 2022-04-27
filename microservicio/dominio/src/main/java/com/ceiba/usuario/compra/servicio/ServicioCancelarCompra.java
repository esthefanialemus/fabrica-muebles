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

        calcularValorMulta(dtoCompra.getTotal(), dtoCompra.getFechaDespacho(),  dtoCompra.getFechaDespacho());
        this.repositorioCompra.cancelarCompra(idCompra);
    }

    private String calcularValorMulta(Double totalCompra, LocalDateTime fechaDespacho, LocalDateTime fechaEntrega ){

        double valorMulta = 0;

        LocalDate fechaActual= LocalDate.now();

        if(( fechaActual.isEqual(fechaDespacho.toLocalDate()) || fechaActual.isAfter(fechaDespacho.toLocalDate())  ) && fechaActual.isBefore(fechaEntrega.toLocalDate()) ){
            valorMulta=totalCompra*0.15;
        }
        return  "El valor de la multa es de: "+valorMulta;

    }
}
