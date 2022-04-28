package com.ceiba.servicio.testdatabuilder;


public class ComandoClienteTestDataBuilder {

    private Long id;
	private String nombre;
	private String apellido;
	private String identificacion;
	private String email;


	public ComandoClienteTestDataBuilder() {

		nombre = "Esthefania ";
		apellido = "Lemus";
		identificacion = "1094972643";
		email = "esthefania.lemus@mail.com";

		
	}

	public ComandoCliente build() {
	 return new ComandoCliente(id,nombre,apellido, identificacion, email);
	}
}
