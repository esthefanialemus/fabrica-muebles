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




	private final RepositorioCompra repositorioCompra;

	public ServicioActualizarCompra(RepositorioCompra repositorioCompra) {
		this.repositorioCompra = repositorioCompra;
	}


	public void ejecutar(Compra compra) {
		validarExistenciaPrevia(compra);
		this.repositorioCompra.actualizar(compra);
	}

	private void validarExistenciaPrevia(Compra compra) {
		boolean existe = this.repositorioCompra.existe(compra.getFechaCompra(),compra.getIdCliente());
		if(existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}


}
