package com.ceiba.consulta.usuario;

import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import org.springframework.stereotype.Component;

@Component
public class ManejadorObtenerUsuario {
	
	private final DaoUsuario daoUsuario;

	public ManejadorObtenerUsuario(DaoUsuario daoUsuario) {
		this.daoUsuario = daoUsuario;
	}
	
	public DtoUsuario ejecutar(Long id) {
		return this.daoUsuario.obtener(id);
	}
	
	public DtoUsuario ejecutar(String username) {
		return this.daoUsuario.obtenerPorNombre(username);
	}

}
