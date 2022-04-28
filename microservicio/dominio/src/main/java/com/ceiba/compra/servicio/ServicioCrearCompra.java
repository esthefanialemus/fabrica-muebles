package com.ceiba.compra.servicio;

import com.ceiba.compra.modelo.entidad.Compra;
import com.ceiba.compra.puerto.repositorio.RepositorioCompra;
import com.ceiba.dominio.excepcion.ExcepcionDiaFestivo;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class ServicioCrearCompra {

    private static final String LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA = "la Compra ya existe en el sistema";
    private static final String LA_COMPRA_NO_SE_REALIZA_FESTIVO = "la Compra no se puede realizar ya que es Festivo";

    private static final String LA_COMPRA_NO_SE_REALIZA_HORARIO = "la Compra no se puede realizar debido a nuestro horario";
    private static final Double LA_COMPRA_ES_CERO = 0.0;
    private static final Double RECARGO_FIN_DE_SEMANA = 0.24;
    private static final int HORA_ENTRADA = 8;
    private static final int HORA_SALIDA = 7;
    private static final int CONSTANTE_NUMERICA = 1;


    private final RepositorioCompra repositorioCompra;

    public ServicioCrearCompra(RepositorioCompra repositorioCompra) {
        this.repositorioCompra = repositorioCompra;
    }

    public Long ejecutar(Compra compra) {
        validarExistenciaPrevia(compra);

        //validarDiaFestivo(compra, null);
        /**
         validarHorarioHabil(compra);
         if (verificarFinDeSemana(compra)) {
         asignarRecargoFinDeSemana(compra);
         }
         asignarFechaEntrega(compra);
         */
        return this.repositorioCompra.crear(compra);

    }

    private void validarExistenciaPrevia(Compra compra) {
        boolean existe = this.repositorioCompra.existe(compra.getFechaCompra(), compra.getIdCliente());
        if (existe) {
            throw new ExcepcionDuplicidad(LA_COMPRA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private boolean verificarFinDeSemana(Compra compra) {

        Calendar fechaCompraCalendar = Calendar.getInstance();
        fechaCompraCalendar.setTime(Date.from(compra.getFechaCompra().toLocalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
        return fechaCompraCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || fechaCompraCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;

    }

    private void asignarRecargoFinDeSemana(Compra compra) {
        if (compra.getTotal().equals(LA_COMPRA_ES_CERO)) {
            compra.setTotal(compra.getTotal() + (compra.getTotal() * RECARGO_FIN_DE_SEMANA));
        }

    }

    /**
     * private void validarDiaFestivo(Compra compra ) {
     * final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
     * <p>
     * <p>
     * if(compra.getFechaCompra().toLocalDate().isEqual(LocalDate.parse(dtoParametro.getValor(), formatter))) {
     * throw new ExcepcionDiaFestivo(LA_COMPRA_NO_SE_REALIZA_FESTIVO);
     * }
     * <p>
     * }
     */
    private void validarHorarioHabil(Compra compra) {

        if (compra.getFechaCompra().getHour() < HORA_ENTRADA || compra.getFechaCompra().getHour() > HORA_SALIDA) {
            throw new ExcepcionDiaFestivo(LA_COMPRA_NO_SE_REALIZA_HORARIO);
        }
    }

    private void asignarFechaDespacho(Compra compra) {
        int cantidadDias = obtenerDiasFechaEntrega();
        compra.setFechaEntrega(compra.getFechaCompra().plusDays(cantidadDias));
    }

    private int obtenerDiasFechaEntrega() {
        return (int) Math.floor(Math.random());
    }
}
