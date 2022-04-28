package com.ceiba.usuario.compra.puerto.repositorio;

import com.ceiba.usuario.compra.modelo.entidad.Compra;

import java.time.LocalDateTime;

public interface RepositorioCompra {




    /**
     * Permite crear una Compra
     *
     * @param Compra
     * @return el id generado
     */
    Long crear(Compra Compra);

    /**
     * Permite actualizar una Compra
     *
     * @param Compra
     */
    void actualizar(Compra Compra);

    /**
     * Permite cancelar una Compra
     *
     * @param id
     */
    public String cancelarCompra(Long idCompra);

    /**
     * Permite validar si existe una compra con la fecha de compra, cliente relacionados
     *
     * @param fechaCompra
     * @param idCliente
     * @return si existe o no
     */
    boolean existe(LocalDateTime fechaCompra, Long idCliente);


    /**
     * Permite validar si existe una compra con la fecha de compra, clienterelacionados
     *
     * @param id
     * @param fechaCompra
     * @param idCliente
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id, LocalDateTime fechaCompra, Long idCliente);

    /**
     * Permite contar cuantas citas existen por dia
     *
     * @param fechaCompra
     * @return cantidad de compras por dia
     */
    Integer contarComprasPorDia(LocalDateTime fechaCompra);

}
