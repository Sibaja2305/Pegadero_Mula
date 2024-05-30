/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Hp EliteBook
 */
public class Caja {
    private int codigoCaja;
    private int codigoSucursal;
    private double montoInicial;
    private double montoFinal;
    private Time fechaApertura;
    private Time fechaCierre;
    private Date FechaCaja;

    public Caja() {
    }

    public Caja(int codigoCaja, int codigoSucursal, double montoInicial, double montoFinal, Time fechaApertura, Time fechaCierre, Date FechaCaja) {
        this.codigoCaja = codigoCaja;
        this.codigoSucursal = codigoSucursal;
        this.montoInicial = montoInicial;
        this.montoFinal = montoFinal;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.FechaCaja = FechaCaja;
    }

    /**
     * @return the codigoCaja
     */
    public int getCodigoCaja() {
        return codigoCaja;
    }

    /**
     * @param codigoCaja the codigoCaja to set
     */
    public void setCodigoCaja(int codigoCaja) {
        this.codigoCaja = codigoCaja;
    }

    /**
     * @return the codigoSucursal
     */
    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    /**
     * @param codigoSucursal the codigoSucursal to set
     */
    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    /**
     * @return the montoInicial
     */
    public double getMontoInicial() {
        return montoInicial;
    }

    /**
     * @param montoInicial the montoInicial to set
     */
    public void setMontoInicial(double montoInicial) {
        this.montoInicial = montoInicial;
    }

    /**
     * @return the montoFinal
     */
    public double getMontoFinal() {
        return montoFinal;
    }

    /**
     * @param montoFinal the montoFinal to set
     */
    public void setMontoFinal(double montoFinal) {
        this.montoFinal = montoFinal;
    }

    /**
     * @return the fechaApertura
     */
    public Time getFechaApertura() {
        return fechaApertura;
    }

    /**
     * @param fechaApertura the fechaApertura to set
     */
    public void setFechaApertura(Time fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * @return the fechaCierre
     */
    public Time getFechaCierre() {
        return fechaCierre;
    }

    /**
     * @param fechaCierre the fechaCierre to set
     */
    public void setFechaCierre(Time fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    /**
     * @return the FechaCaja
     */
    public Date getFechaCaja() {
        return FechaCaja;
    }

    /**
     * @param FechaCaja the FechaCaja to set
     */
    public void setFechaCaja(Date FechaCaja) {
        this.FechaCaja = FechaCaja;
    }

    @Override
    public String toString() {
        return "Caja{" + "codigoCaja=" + codigoCaja + ", codigoSucursal=" 
                + codigoSucursal + ", montoInicial=" + montoInicial + ", montoFinal=" 
                + montoFinal + ", fechaApertura=" + fechaApertura + ", fechaCierre=" 
                + fechaCierre + ", FechaCaja=" + FechaCaja + '}';
    }

    
    
}
