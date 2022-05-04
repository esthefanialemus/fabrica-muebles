package com.ceiba.compra.puerto.repositorio;

import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDateTime;

public interface RepositorioCompra {
	/**
	 * Permite crear una Compra
	 * 
	 * @param Compra
	 * @return el id generado
	 */
	Long crear(Compra Compra);

	/**
	 * Permite actualizar una Compra
	 * 
	 * @param Compra
	 */
	void actualizar(Compra Compra);

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


	public String cancelarCompra(Long idCompra);}
