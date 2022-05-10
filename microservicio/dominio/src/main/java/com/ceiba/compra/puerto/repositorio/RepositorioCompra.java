package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDateTime;

public interface RepositorioCompra {
	/**
	 * Permite crear una Compra
	 * 
	 * @param compra
	 * @return el id generado
	 */
	Long crear(Compra compra);

	/**
	 * Permite actualizar una Compra
	 * 
	 * @param compra
	 */
	void actualizar(Compra compra);

	/**
	 * Permite eliminar una Compra
	 * 
	 * @param id
	 */
	void eliminar(Long id);

	/**
	 * Permite validar si existe una compra con la fecha de compra, cliente relacionados
	 * 
	 * @param fechaCompra
	 * @param idCliente
	 * @return si existe o no
	 */
	boolean existe(LocalDateTime fechaCompra, Long idCliente);
	
	
	/**
	 * Permite validar si existe una compra con la fecha de compra, clienterelacionados
	 * 
	 * @param id
	 * @param fechaCompra
	 * @param idCliente
	 * @return si existe o no
	 */
	boolean existeExcluyendoId(Long id, LocalDateTime fechaCompra, Long idCliente);




	/**
	 * Permite cancelar una compra seteando el total con la multa
	 * @param compra
	 */
    void cancelarCompra(Compra compra);
}
