package com.ceiba.servicio.usuario;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.testdatabuilder.UsuarioTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarUsuarioTest {

	@Test
	public void validarUsuarioExistenciaPreviaTest() {
		// arrange
		Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();

		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

		Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong())).thenReturn(true);

		ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);

		// act - assert
		BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,
				"El usuario ya existe en el sistema");
	}

	@Test
	public  void validarExistenciaUsuarioTest(){
		Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();

		RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);

		Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong())).thenReturn(true);

		ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);

		// act - assert
		//BasePrueba.assertEquals(servicioActualizarUsuario.ejecutar(usuario), usuario);

	}
}
