package com.ceiba.itemsCompra.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.itemsCompra.modelo.entidad.itemsCompra;
import com.ceiba.itemsCompra.puerto.repositorio.RepositorioItemsCompra;

public class ServicioCrearItemsCompra {

	private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";


	private final RepositorioItemsCompra repositorioItemsCompra;

	public ServicioCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
	}

	public Long ejecutar(itemsCompra itemsCompra) {
		validarExistenciaPrevia(itemsCompra);

		return this.repositorioItemsCompra.crear(itemsCompra);
	}

	private void validarExistenciaPrevia(itemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existe(itemsCompra.getIdCompra());
		if (existe) {
			throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
		}
	}


}
