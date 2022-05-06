package com.ceiba.items_compra.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.items_compra.modelo.entidad.ItemsCompra;
import com.ceiba.items_compra.puerto.repositorio.RepositorioItemsCompra;

public class ServicioCrearItemsCompra {

	private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";


	private final RepositorioItemsCompra repositorioItemsCompra;

	public ServicioCrearItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
	}

	public Long ejecutar(ItemsCompra itemsCompra) {
		validarExistenciaPrevia(itemsCompra);

		return this.repositorioItemsCompra.crear(itemsCompra);
	}

	private void validarExistenciaPrevia(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existe(itemsCompra.getIdCompra());
		if (existe) {
			throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
		}
	}


}
