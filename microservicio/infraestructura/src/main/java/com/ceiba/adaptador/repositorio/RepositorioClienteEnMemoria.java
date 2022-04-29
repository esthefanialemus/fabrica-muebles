package com.ceiba.adaptador.repositorio;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositorioClienteEnMemoria  implements RepositorioCliente {

    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public List<DtoCliente> listar(){
        return clientes.stream()
                .map(cliente1 -> {
                    return new DtoCliente(cliente1.getId());
                })
                .collect(Collectors.toList());
    }

    @Override
    public void guardar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public boolean existe(String identificacion) {
        return clientes.stream()
                .filter(usuario -> usuario.getId()
                        .equals(identificacion))
                .findFirst()
                .isPresent();
    }

    @Override
    public Long crear(Cliente Cliente) {
        return null;
    }

    @Override
    public void actualizar(Cliente Cliente) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existeExcluyendoId(Long id, String identificacion) {
        return false;
    }

}
