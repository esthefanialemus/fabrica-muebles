package com.ceiba.cliente.servicio;


import com.ceiba.comando.ComandoCliente;

import java.time.LocalDateTime;

public class ComandoClienteTestDataBuilder {

    private Long id;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String email;

	private LocalDateTime fechaCreacion;


	public ComandoClienteTestDataBuilder()  {

		nombre = "mini ";
		apellido = "p";
		identificacion = "6789";
		email = "lemus@mail.com";
		fechaCreacion = LocalDateTime.now();

		
	}

	public ComandoCliente build() {
	 return new ComandoCliente(id,nombre,apellido, identificacion, email,fechaCreacion);
	}
}
