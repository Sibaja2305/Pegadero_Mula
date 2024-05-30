/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Date;

/**
 *
 * @author Hp EliteBook
 */
public class HorasExtras {
    private int codigoHoraExtra;
    private Date fechaHoraExtra;
    private int cantidadHoras;

    public HorasExtras() {
    }

    public HorasExtras(int codigoHoraExtra, Date fechaHoraExtra, int cantidadHoras) {
        this.codigoHoraExtra = codigoHoraExtra;
        this.fechaHoraExtra = fechaHoraExtra;
        this.cantidadHoras = cantidadHoras;
    }

    /**
     * @return the codigoHoraExtra
     */
    public int getCodigoHoraExtra() {
        return codigoHoraExtra;
    }

    /**
     * @param codigoHoraExtra the codigoHoraExtra to set
     */
    public void setCodigoHoraExtra(int codigoHoraExtra) {
        this.codigoHoraExtra = codigoHoraExtra;
    }

    /**
     * @return the fechaHoraExtra
     */
    public Date getFechaHoraExtra() {
        return fechaHoraExtra;
    }

    /**
     * @param fechaHoraExtra the fechaHoraExtra to set
     */
    public void setFechaHoraExtra(Date fechaHoraExtra) {
        this.fechaHoraExtra = fechaHoraExtra;
    }

    /**
     * @return the cantidadHoras
     */
    public int getCantidadHoras() {
        return cantidadHoras;
    }

    /**
     * @param cantidadHoras the cantidadHoras to set
     */
    public void setCantidadHoras(int cantidadHoras) {
        this.cantidadHoras = cantidadHoras;
    }

    @Override
    public String toString() {
        return "HorasExtras{" + "codigoHoraExtra=" + codigoHoraExtra 
                + ", fechaHoraExtra=" + fechaHoraExtra + ", cantidadHoras=" + cantidadHoras + '}';
    }
    
}
