package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionCancelacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ServicioCancelarCompra {

	private static final String LA_COMPRA_NO_SE_PUEDE_CANCELAR = "La Compra solo puede ser cancelada antes de la fecha de despacho";

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "La Compra ya existe en el sistema";

	private static final Double PORCENTAJE_MULTA_CANCELACION_COMPRA = 0.15;

	private final DaoCompra daoCompra;

	private final RepositorioCompra repositorioCompra;

	public ServicioCancelarCompra(DaoCompra daoCompra, RepositorioCompra repositorioCompra) {
		this.daoCompra = daoCompra;
		this.repositorioCompra = repositorioCompra;

	}


	public void ejecutar(Compra compra) {
		DtoCompra dtoCompra = daoCompra.listarCompraPorId(compra.getId());

		validarExistenciaPrevia(compra);
		validarCancelacionCompra( dtoCompra.getFechaDespacho(),  dtoCompra.getFechaEntrega());
		cancelarCompra(compra);
		this.repositorioCompra.cancelarCompra(compra);
	}



	private void validarExistenciaPrevia(Compra compra) {
		boolean existe = this.repositorioCompra.existe(compra.getFechaCompra(),compra.getIdCliente());
		if(existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}

	private void validarCancelacionCompra(LocalDateTime fechaDespacho, LocalDateTime fechaEntrega) {

		LocalDate fechaActual= LocalDate.now();

		if(( fechaActual.isEqual(fechaDespacho.toLocalDate()) || fechaActual.isAfter(fechaDespacho.toLocalDate())  ) && fechaActual.isBefore(fechaEntrega.toLocalDate()) ){
				throw new ExcepcionCancelacion(LA_COMPRA_NO_SE_PUEDE_CANCELAR);
		}
	}

	private void cancelarCompra(Compra compra) {
		compra.setTotal(compra.getTotal()* PORCENTAJE_MULTA_CANCELACION_COMPRA);
	}
}
