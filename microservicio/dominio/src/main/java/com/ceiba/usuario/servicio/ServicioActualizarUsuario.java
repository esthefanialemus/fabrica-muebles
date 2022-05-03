package com.ceiba.usuario.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarUsuario {

    private static final String EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }


    public void ejecutar(Usuario usuario) {
       if(validarExistenciaPrevia(usuario)) {
           throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE_EN_EL_SISTEMA);
       }else {
           this.repositorioUsuario.actualizar(usuario);
       }

    }

    private boolean validarExistenciaPrevia(Usuario usuario) {

        return this.repositorioUsuario.existeExcluyendoId(usuario.getId());
    }
}
