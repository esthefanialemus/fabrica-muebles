package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioEliminarUsuario {

    private final RepositorioUsuario repositorioUsuario;

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";
    public ServicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public void ejecutar(Long id) {
        if(validarExistencia(id)){
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
        }else{
            this.repositorioUsuario.eliminar(id);
        }

    }

    public boolean validarExistencia(Long id){
        return this.repositorioUsuario.existe(String.valueOf(id));
    }
}
