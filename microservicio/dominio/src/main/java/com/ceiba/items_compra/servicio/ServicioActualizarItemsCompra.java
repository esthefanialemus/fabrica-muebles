package com.ceiba.items_compra.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.items_compra.modelo.entidad.ItemsCompra;
import com.ceiba.items_compra.puerto.repositorio.RepositorioItemsCompra;

public class ServicioActualizarItemsCompra {

	private static final String ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA = "Estos Items de Compra ya existe en el sistema";

	private final RepositorioItemsCompra repositorioItemsCompra;

	public ServicioActualizarItemsCompra(RepositorioItemsCompra repositorioItemsCompra) {
		this.repositorioItemsCompra = repositorioItemsCompra;
	}

	public void ejecutar(ItemsCompra itemsCompra) {
		validarExistenciaPrevia(itemsCompra);


		 this.repositorioItemsCompra.actualizar(itemsCompra);
	}

	private void validarExistenciaPrevia(ItemsCompra itemsCompra) {
		boolean existe = this.repositorioItemsCompra.existe(
				itemsCompra.getIdCompra());
		if (existe) {
			throw new ExcepcionDuplicidad(ESTOS_ITEMS_YA_EXISTE_EN_EL_SISTEMA);
		}
	}




}
