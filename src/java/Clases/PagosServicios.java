/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Timestamp;

/**
 *
 * @author Hp EliteBook
 */
public class PagosServicios {
   private int codigoPagoServicio;
   private int codigoServicio;
   private int codigoSucursal;
   private double pagoServicio;
   private Timestamp  fechaPago;

    public PagosServicios() {
    }

    public PagosServicios(int codigoPagoServicio, int codigoServicio, int codigoSucursal, double pagoServicio, Timestamp fechaPago) {
        this.codigoPagoServicio = codigoPagoServicio;
        this.codigoServicio = codigoServicio;
        this.codigoSucursal = codigoSucursal;
        this.pagoServicio = pagoServicio;
        this.fechaPago = fechaPago;
    }

    /**
     * @return the codigoPagoServicio
     */
    public int getCodigoPagoServicio() {
        return codigoPagoServicio;
    }

    /**
     * @param codigoPagoServicio the codigoPagoServicio to set
     */
    public void setCodigoPagoServicio(int codigoPagoServicio) {
        this.codigoPagoServicio = codigoPagoServicio;
    }

    /**
     * @return the codigoServicio
     */
    public int getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * @param codigoServicio the codigoServicio to set
     */
    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
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
     * @return the pagoServicio
     */
    public double getPagoServicio() {
        return pagoServicio;
    }

    /**
     * @param pagoServicio the pagoServicio to set
     */
    public void setPagoServicio(double pagoServicio) {
        this.pagoServicio = pagoServicio;
    }

    /**
     * @return the fechaPago
     */
    public Timestamp getFechaPago() {
        return fechaPago;
    }

    /**
     * @param fechaPago the fechaPago to set
     */
    public void setFechaPago(Timestamp fechaPago) {
        this.fechaPago = fechaPago;
    }

    @Override
    public String toString() {
        return "PagosServicios{" + "codigoPagoServicio=" 
                + codigoPagoServicio + ", codigoServicio=" + codigoServicio 
                + ", codigoSucursal=" + codigoSucursal + ", pagoServicio=" 
                + pagoServicio + ", fechaPago=" + fechaPago + '}';
    }
   
}
