package com.ceiba.compra.modelo.entidad;

import com.ceiba.dominio.excepcion.ExcepcionHorario;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Compra {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_COMPRA = "Se debe ingresar la fecha de compra";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_ENTREGA = "Se debe ingresar la fecha entrega de entrega";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_DESPACHO = "Se debe ingresar la fecha despacho de despacho";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO_TOTAL_COMPRA = "Se debe ingresar el precio total de la compra";
    private static final String SE_DEBE_INGRESAR_EL_CLIENTE = "Se debe ingresar el cliente a la compra";

    private static final String LA_COMPRA_NO_SE_REALIZA_FUERA_DE_HORARIO_DE_ATENCION = "la Compra no se puede realizar fuera de nuestro horario de atencion";




    private static final Double LA_COMPRA_ES_CERO = 0.0 ;

    private static final Double RECARGO_FIN_DE_SEMANA = 0.24 ;

    private static final int HORA_ENTRADA = 8 ;
    private static final int HORA_SALIDA = 19 ;

    private static final int CANTIDAD_DIAS_DESPACHO = 3;

    private static final int CANTIDAD_DIAS_ENTREGA = 4;
    private Long id;
    private Long idCliente;
    private Double total;
    private LocalDateTime fechaCompra;
    private LocalDateTime fechaEntrega;
    private LocalDateTime fechaDespacho;

    public Compra(Long id, Long idCliente, Double total, LocalDateTime fechaCompra, LocalDateTime fechaEntrega, LocalDateTime fechaDespacho) {

        validarObligatorio(idCliente, SE_DEBE_INGRESAR_EL_CLIENTE);
        validarObligatorio(total,     SE_DEBE_INGRESAR_EL_PRECIO_TOTAL_COMPRA);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_COMPRA);
        validarObligatorio(fechaEntrega, SE_DEBE_INGRESAR_LA_FECHA_ENTREGA);
        validarObligatorio(fechaDespacho, SE_DEBE_INGRESAR_LA_FECHA_DESPACHO);
        validarHorarioHabil(fechaCompra,LA_COMPRA_NO_SE_REALIZA_FUERA_DE_HORARIO_DE_ATENCION);

        this.id = id;
        this.idCliente = idCliente;
        this.total = asignarValorTotal(fechaCompra,total);
        this.fechaCompra = fechaCompra;
        this.fechaEntrega = asignarFechaEntrega(fechaCompra);
        this.fechaDespacho = asignarFechaDespacho(fechaCompra);
    }

    private void validarHorarioHabil(LocalDateTime fechaCompra, String msj) {

        if(fechaCompra.getHour() < HORA_ENTRADA || fechaCompra.getHour() > HORA_SALIDA ){
            msj=LA_COMPRA_NO_SE_REALIZA_FUERA_DE_HORARIO_DE_ATENCION;
            throw new ExcepcionHorario(msj);
        }
    }

    private double asignarValorTotal(LocalDateTime fechaCompra, Double total){
        double r=total;
        if(total==0){
            r= asignarRecargoFinDeSemana(fechaCompra,total);
        }
        return r;

    }

    public static boolean verificarFinDeSemana(LocalDateTime fechaCompra) {

        boolean esFinde=false;
        if(fechaCompra.getDayOfWeek().equals(DayOfWeek.SUNDAY) || fechaCompra.getDayOfWeek().equals(DayOfWeek.SATURDAY)){
            esFinde=true;
        }
      return esFinde;

    }

    public static double asignarRecargoFinDeSemana(LocalDateTime fechaCompra, Double total) {

        double valorTotal= 0;
        if ( verificarFinDeSemana(fechaCompra)) {
           valorTotal =  total * RECARGO_FIN_DE_SEMANA;
        }
        return valorTotal;

    }

    private LocalDateTime asignarFechaDespacho(LocalDateTime fechaCompra) {

        return (fechaCompra.plusDays(CANTIDAD_DIAS_DESPACHO));

    }
    private LocalDateTime asignarFechaEntrega(LocalDateTime fechaCompra) {

       return (fechaCompra.plusDays(CANTIDAD_DIAS_ENTREGA));

    }


}
