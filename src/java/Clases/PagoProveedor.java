/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class PagoProveedor {
    private int codigoPagoProveedor;
    private int codigoProveedor;
    private double montonPagoProveedor;

    public PagoProveedor() {
    }

    public PagoProveedor(int codigoPagoProveedor, int codigoProveedor, double montonPagoProveedor) {
        this.codigoPagoProveedor = codigoPagoProveedor;
        this.codigoProveedor = codigoProveedor;
        this.montonPagoProveedor = montonPagoProveedor;
    }

    /**
     * @return the codigoPagoProveedor
     */
    public int getCodigoPagoProveedor() {
        return codigoPagoProveedor;
    }

    /**
     * @param codigoPagoProveedor the codigoPagoProveedor to set
     */
    public void setCodigoPagoProveedor(int codigoPagoProveedor) {
        this.codigoPagoProveedor = codigoPagoProveedor;
    }

    /**
     * @return the codigoProveedor
     */
    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    /**
     * @param codigoProveedor the codigoProveedor to set
     */
    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    /**
     * @return the montonPagoProveedor
     */
    public double getMontonPagoProveedor() {
        return montonPagoProveedor;
    }

    /**
     * @param montonPagoProveedor the montonPagoProveedor to set
     */
    public void setMontonPagoProveedor(double montonPagoProveedor) {
        this.montonPagoProveedor = montonPagoProveedor;
    }

    @Override
    public String toString() {
        return "PagoProveedor{" + "codigoPagoProveedor=" + codigoPagoProveedor 
                + ", codigoProveedor=" + codigoProveedor + ", montonPagoProveedor=" 
                + montonPagoProveedor + '}';
    }
    
}
