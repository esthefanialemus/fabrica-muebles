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
		if(verificarFinDeSemana(compra)){
			asignarRecargoFinDeSemana(compra);

		}
		asignarFechaEntrega(compra);
		return this.repositorioCompra.crear(compra);
	}

	private void validarExistenciaPrevia(Compra compra) {
		boolean existe = this.repositorioCompra.existe(compra.getFechaCompra(), compra.getIdCliente());
		if(existe) {
			throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
		}
	}



	private boolean verificarFinDeSemana(Compra compra) {

		Calendar fechaCompraCalendar = Calendar.getInstance();
		fechaCompraCalendar.setTime(Date.from(compra.getFechaCompra().toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		return fechaCompraCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || fechaCompraCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ;

	}


	private void asignarRecargoFinDeSemana(Compra compra) {
		if ( compra.getTotal().equals(LA_COMPRA_ES_CERO)) {
			compra.setTotal(compra.getTotal() + (compra.getTotal() * RECARGO_FIN_DE_SEMANA));
		}

	}


	private void asignarFechaEntrega(Compra compra) {
		int cantidadDias = obtenerDiasFechaRandom();
		compra.setFechaEntrega(compra.getFechaCompra().plusDays(cantidadDias));
		compra.setFechaDespacho(compra.getFechaCompra().plusDays(cantidadDias+CANTIDAD_DIAS_DESPACHO_COMPRA));
	}

	private int obtenerDiasFechaRandom() {
		return (int)Math.floor(Math.random()*(DIAS_MAXIMOS_FECHAS - DIAS_MINIMOS_FECHAS +CONSTANTE_NUMERICA)+ DIAS_MINIMOS_FECHAS);
	}


}
