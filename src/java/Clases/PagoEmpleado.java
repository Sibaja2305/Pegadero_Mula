/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author Hp EliteBook
 */
public class PagoEmpleado {
   private int codigoPagoEmpleado;
   private int codigoEmpleado;
   private int CodigoHorasExtras;
   private int CodigoEstadoPago;
   private Date fechaEmision;
   private Date FechaPago;
   private double montonPago;
   private double montoPagoCCSS;
   private int codigoBonificacion;

    public PagoEmpleado() {
    }

    public PagoEmpleado(int codigoPagoEmpleado, int codigoEmpleado, int CodigoHorasExtras, int CodigoEstadoPago, Date fechaEmision, Date FechaPago, double montonPago, double montoPagoCCSS, int codigoBonificacion) {
        this.codigoPagoEmpleado = codigoPagoEmpleado;
        this.codigoEmpleado = codigoEmpleado;
        this.CodigoHorasExtras = CodigoHorasExtras;
        this.CodigoEstadoPago = CodigoEstadoPago;
        this.fechaEmision = fechaEmision;
        this.FechaPago = FechaPago;
        this.montonPago = montonPago;
        this.montoPagoCCSS = montoPagoCCSS;
        this.codigoBonificacion = codigoBonificacion;
    }

    /**
     * @return the codigoPagoEmpleado
     */
    public int getCodigoPagoEmpleado() {
        return codigoPagoEmpleado;
    }

    /**
     * @param codigoPagoEmpleado the codigoPagoEmpleado to set
     */
    public void setCodigoPagoEmpleado(int codigoPagoEmpleado) {
        this.codigoPagoEmpleado = codigoPagoEmpleado;
    }

    /**
     * @return the codigoEmpleado
     */
    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    /**
     * @param codigoEmpleado the codigoEmpleado to set
     */
    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    /**
     * @return the CodigoHorasExtras
     */
    public int getCodigoHorasExtras() {
        return CodigoHorasExtras;
    }

    /**
     * @param CodigoHorasExtras the CodigoHorasExtras to set
     */
    public void setCodigoHorasExtras(int CodigoHorasExtras) {
        this.CodigoHorasExtras = CodigoHorasExtras;
    }

    /**
     * @return the CodigoEstadoPago
     */
    public int getCodigoEstadoPago() {
        return CodigoEstadoPago;
    }

    /**
     * @param CodigoEstadoPago the CodigoEstadoPago to set
     */
    public void setCodigoEstadoPago(int CodigoEstadoPago) {
        this.CodigoEstadoPago = CodigoEstadoPago;
    }

    /**
     * @return the fechaEmision
     */
    public Date getFechaEmision() {
        return fechaEmision;
    }

    /**
     * @param fechaEmision the fechaEmision to set
     */
    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     * @return the FechaPago
     */
    public Date getFechaPago() {
        return FechaPago;
    }

    /**
     * @param FechaPago the FechaPago to set
     */
    public void setFechaPago(Date FechaPago) {
        this.FechaPago = FechaPago;
    }

    /**
     * @return the montonPago
     */
    public double getMontonPago() {
        return montonPago;
    }

    /**
     * @param montonPago the montonPago to set
     */
    public void setMontonPago(double montonPago) {
        this.montonPago = montonPago;
    }

    /**
     * @return the montoPagoCCSS
     */
    public double getMontoPagoCCSS() {
        return montoPagoCCSS;
    }

    /**
     * @param montoPagoCCSS the montoPagoCCSS to set
     */
    public void setMontoPagoCCSS(double montoPagoCCSS) {
        this.montoPagoCCSS = montoPagoCCSS;
    }

    /**
     * @return the codigoBonificacion
     */
    public int getCodigoBonificacion() {
        return codigoBonificacion;
    }

    /**
     * @param codigoBonificacion the codigoBonificacion to set
     */
    public void setCodigoBonificacion(int codigoBonificacion) {
        this.codigoBonificacion = codigoBonificacion;
    }

    @Override
    public String toString() {
        return "PagoEmpleado{" + "codigoPagoEmpleado=" + codigoPagoEmpleado + 
                ", codigoEmpleado=" + codigoEmpleado + ", CodigoHorasExtras=" + 
                CodigoHorasExtras + ", CodigoEstadoPago=" + CodigoEstadoPago + 
                ", fechaEmision=" + fechaEmision + ", FechaPago=" + FechaPago + 
                ", montonPago=" + montonPago + ", montoPagoCCSS=" + montoPagoCCSS +
                ", codigoBonificacion=" + codigoBonificacion + '}';
    }
   
}
