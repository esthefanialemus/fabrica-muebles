package com.ceiba.cliente.servicio;


import com.ceiba.comando.manejador.ComandoCliente;

import java.time.LocalDateTime;

public class ComandoClienteTestDataBuilder {

    private Long id;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String email;

	private LocalDateTime fechaCreacion;


	public ComandoClienteTestDataBuilder()  {

		nombre = "Esthefania ";
		apellido = "Lemus";
		identificacion = "1094972643";
		email = "esthefania.lemus@mail.com";
		fechaCreacion = LocalDateTime.now();

		
	}

	public ComandoCliente build() {
	 return new ComandoCliente(id,nombre,apellido, identificacion, email,fechaCreacion);
	}
}
