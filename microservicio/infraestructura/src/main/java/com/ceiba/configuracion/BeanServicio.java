package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {



    /*
     *
     * SERVICIOS DEL CLIENTE
     *
     */
    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
        return new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioEliminarCliente(repositorioCliente);
    }

    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
        return new ServicioActualizarCliente(repositorioCliente);
    }


    /*
     *
     * SERVICIOS DEL USUARIO
     *
     */

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }


    /*
     *
     * SERVICIOS DEL PRODUCTO
     *
     */

    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto) {
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioEliminarProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto) {
        return new ServicioActualizarProducto(repositorioProducto);
    }


}
