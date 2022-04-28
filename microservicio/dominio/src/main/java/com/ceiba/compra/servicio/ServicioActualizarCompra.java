package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioActualizarCompra {
    private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La Compra ya existe en el sistema";

    private static final Double PORCENTAJE_MULTA_CANCELACION = 0.15;
    private final RepositorioCompra repositorioCompra;

    private final DaoCompra daoCompra;

    public ServicioActualizarCompra(RepositorioCompra repositorioCompra , DaoCompra daoCompra) {

        this.repositorioCompra = repositorioCompra;
        this.daoCompra = daoCompra;
    }

    public void ejecutar(Compra compra) {

        DtoCompra dtoCompra = daoCompra.listarCompraPorId(compra.getId());

        validarExistenciaPrevia(compra);
        if(validarCancelacionCompra( dtoCompra.getFechaDespacho(),  dtoCompra.getFechaDespacho())) {
            cancelarCompra(compra);

        }
        this.repositorioCompra.actualizar(compra);
    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existeExcluyendoId(compra.getId(),compra.getFechaCompra(),compra.getIdCliente());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }


    private boolean validarCancelacionCompra(LocalDateTime fechaDespacho, LocalDateTime fechaEntrega) {

        LocalDate fechaActual= LocalDate.now();

        if(( fechaActual.isEqual(fechaDespacho.toLocalDate()) || fechaActual.isAfter(fechaDespacho.toLocalDate())  ) && fechaActual.isBefore(fechaEntrega.toLocalDate()) ){
            return  true;
        }else{
            return  false;
        }
    }

    private void cancelarCompra(Compra compra){

     compra.setTotal(compra.getTotal() - (compra.getTotal()*PORCENTAJE_MULTA_CANCELACION));






    }
}
