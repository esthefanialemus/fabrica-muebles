package com.ceiba.cliente.servicio;


import com.ceiba.comando.ComandoCliente;


public class ComandoClienteTestDataBuilder {

    private Long id;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String email;




	public ComandoClienteTestDataBuilder()  {
		id= 1L;
		nombre = "mini ";
		apellido = "p";
		identificacion = "6789";
		email = "lemus@mail.com";

	}

	public ComandoCliente build() {
	 return new ComandoCliente(id,nombre,apellido, identificacion, email);
	}
}
