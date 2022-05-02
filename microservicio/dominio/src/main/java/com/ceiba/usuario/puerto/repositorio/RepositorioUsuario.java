package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Usuario;

public interface RepositorioUsuario {

    /**
     * Permite crear un usuario
     *
     * @param usuario
     * @return el id generado
     */
    Long crear(Usuario usuario);

    /**
     * Permite actualizar un Usuario
     * @param usuario
     */
    void actualizar(Usuario usuario);

    /**
     * Permite eliminar un usuario
     *
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un username
     *
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un usuario con un username excluyendo un id
     *
     * @param id
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id);
}
