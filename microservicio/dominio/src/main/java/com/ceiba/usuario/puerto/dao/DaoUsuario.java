package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoUsuario {

	/**
	 * Permite listar usuarios
	 * 
	 * @return los usuarios
	 */
	List<DtoUsuario> listar();
	
	/**
	 * Permite obtener un usuario por su id
	 * 
	 * @param id
	 * @return el usuario
	 */
	DtoUsuario obtener(Long id);
	
	/**
	 * 
	 * @param username
	 * @return el usuario
	 */
	DtoUsuario obtenerPorNombre(String username);
	
}
