package com.ceiba.servicio.usuario;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import com.ceiba.testdatabuilder.UsuarioTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioCrearUsuarioTest {



    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

        Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);

        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario),

                ExcepcionDuplicidad.class,
                "El usuario ya existe en el sistema");
    }
}
