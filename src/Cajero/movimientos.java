/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cajero;

import java.util.Calendar;


/**
 *
 * @author izacc
 */
public class movimientos {
    private String tipoMovimiento;
    private String fecha;
    private String hora;
    private double monto;

    public movimientos(String tipoMovimiento, double monto) {
        this.tipoMovimiento = tipoMovimiento;
        this.fecha = ""+Calendar.DATE;
        this.hora = ""+Calendar.HOUR_OF_DAY;
        this.monto = monto;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public double getMonto() {
        return monto;
    }
}
