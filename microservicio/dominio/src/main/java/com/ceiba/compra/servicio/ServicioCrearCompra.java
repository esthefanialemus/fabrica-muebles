package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionHorario;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class ServicioCrearCompra {

	private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "la Compra ya existe en el sistema";

	private static final Double LA_COMPRA_ES_CERO = 0.0 ;


	private static final int CANTIDAD_DIAS_DESPACHO_COMPRA = 3 ;
	private static final Double RECARGO_FIN_DE_SEMANA = 0.24 ;


	private static final int DIAS_MINIMOS_FECHAS = 5;
	private static final int DIAS_MAXIMOS_FECHAS = 8;

	private static final int CONSTANTE_NUMERICA = 1;

	private final RepositorioCompra repositorioCompra;

	public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
		this.repositorioCompra = repositorioCompra;
	}

	public Long ejecutar(Compra compra) {
		validarExistenciaPrevia(compra);

		return this.repositorioCompra.crear(compra);
	}

	private void validarExistenciaPrevia(Compra compra) {
		boolean existe = this.repositorioCompra.existe(compra.getFechaCompra(), compra.getIdCliente());
		if(existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}





}
