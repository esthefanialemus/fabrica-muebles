package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.dto.DtoCompra;
import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.dao.DaoCompra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionCancelacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;

public class ServicioCancelarCompra {

	private static final String LA_COMPRA_NO_SE_PUEDE_CANCELAR = "La Compra solo puede ser cancelada antes de la fecha de despacho";


	private final DaoCompra daoCompra;

	private final RepositorioCompra repositorioCompra;

	public ServicioCancelarCompra(DaoCompra daoCompra, RepositorioCompra repositorioCompra) {
		this.daoCompra = daoCompra;
		this.repositorioCompra = repositorioCompra;

	}


	public void ejecutar(Compra compra) {



		validarCancelacionCompra(compra.getId());
		this.repositorioCompra.cancelarCompra(compra);
	}





	private void validarCancelacionCompra(Long id) {
		DtoCompra dtoCompra =  this.daoCompra.listarCompraPorId(id);

		LocalDate fechaActual= LocalDate.now();

		if(fechaActual.isBefore(dtoCompra.getFechaDespacho().toLocalDate())){
			throw new ExcepcionCancelacion(LA_COMPRA_NO_SE_PUEDE_CANCELAR);
		}

	}


}
