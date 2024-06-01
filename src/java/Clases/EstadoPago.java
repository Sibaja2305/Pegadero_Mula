/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class EstadoPago {
  private int codigoEstadoPago;
private String EstadoPago;

    public EstadoPago() {
    }

    public EstadoPago(int codigoEstadoPago, String EstadoPago) {
        this.codigoEstadoPago = codigoEstadoPago;
        this.EstadoPago = EstadoPago;
    }

    /**
     * @return the codigoEstadoPago
     */
    public int getCodigoEstadoPago() {
        return codigoEstadoPago;
    }

    /**
     * @param codigoEstadoPago the codigoEstadoPago to set
     */
    public void setCodigoEstadoPago(int codigoEstadoPago) {
        this.codigoEstadoPago = codigoEstadoPago;
    }

    /**
     * @return the EstadoPago
     */
    public String getEstadoPago() {
        return EstadoPago;
    }

    /**
     * @param EstadoPago the EstadoPago to set
     */
    public void setEstadoPago(String EstadoPago) {
        this.EstadoPago = EstadoPago;
    }

    @Override
    public String toString() {
        return "EstadoPago{" + "codigoEstadoPago=" 
                + codigoEstadoPago + ", EstadoPago=" + EstadoPago + '}';
    }

}
