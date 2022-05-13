package com.ceiba.compra.servicio.testdatabuilder;

import com.ceiba.compra.modelo.entidad.Compra;

import java.time.LocalDateTime;

public class CompraTestDataBuilder {
    private Long id;
    private Long idCliente;
    private Double total;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEntrega;
    private LocalDateTime fechaDespacho;

    public CompraTestDataBuilder() {
       id=2L;
       idCliente=1L;
        total=800.000;
       fechaCompra = LocalDateTime.parse("2022-05-18T09:12:43");
       fechaDespacho=LocalDateTime.now().plusDays(4);
       fechaEntrega=LocalDateTime.now().plusDays(7);
    }

    public CompraTestDataBuilder validarId(Long id){
        this.id=id;
        return this;
    }
    public CompraTestDataBuilder validarCliente(Long idCliente){
        this.idCliente=idCliente;
        return this;
    }

    public CompraTestDataBuilder validarTotalCompra(Double total){
        this.total=total;
        return this;
    }

    public CompraTestDataBuilder validarFechaCompra(LocalDateTime fechaCompra){
        this.fechaCompra=fechaCompra;
        return this;
    }

    public CompraTestDataBuilder validarFechaDespacho(LocalDateTime fechaDespacho){
        this.fechaDespacho=fechaDespacho;
        return this;
    }

    public CompraTestDataBuilder validarFechaEntrega(LocalDateTime fechaEntrega){
        this.fechaEntrega=fechaEntrega;
        return this;
    }

    public CompraTestDataBuilder verificarHorarioDeAtencion(LocalDateTime fechaCompra){
        this.fechaCompra=fechaCompra;
        return this;
    }

    public CompraTestDataBuilder validarFinDeSemana(LocalDateTime fechaCompra){
        this.fechaCompra=fechaCompra;
        return this;
    }

    public Compra build (){
        return new Compra(id,idCliente,total,fechaCompra,fechaEntrega,fechaDespacho);
    }
}
