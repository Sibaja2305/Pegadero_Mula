/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class Ingredientes {
    private int codigoIngrediente;
    private int codigoSucursal;
    private int codigoProveedor;
    private String nombreIngrediente;
    private double cantidad;
    private int codigoUnidadMedida;

    public Ingredientes() {
    }

    public Ingredientes(int codigoIngrediente, int codigoSucursal, int codigoProveedor, String nombreIngrediente, double cantidad, int codigoUnidadMedida) {
        this.codigoIngrediente = codigoIngrediente;
        this.codigoSucursal = codigoSucursal;
        this.codigoProveedor = codigoProveedor;
        this.nombreIngrediente = nombreIngrediente;
        this.cantidad = cantidad;
        this.codigoUnidadMedida = codigoUnidadMedida;
    }

    /**
     * @return the codigoIngrediente
     */
    public int getCodigoIngrediente() {
        return codigoIngrediente;
    }

    /**
     * @param codigoIngrediente the codigoIngrediente to set
     */
    public void setCodigoIngrediente(int codigoIngrediente) {
        this.codigoIngrediente = codigoIngrediente;
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
     * @return the nombreIngrediente
     */
    public String getNombreIngrediente() {
        return nombreIngrediente;
    }

    /**
     * @param nombreIngrediente the nombreIngrediente to set
     */
    public void setNombreIngrediente(String nombreIngrediente) {
        this.nombreIngrediente = nombreIngrediente;
    }

    /**
     * @return the cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the codigoUnidadMedida
     */
    public int getCodigoUnidadMedida() {
        return codigoUnidadMedida;
    }

    /**
     * @param codigoUnidadMedida the codigoUnidadMedida to set
     */
    public void setCodigoUnidadMedida(int codigoUnidadMedida) {
        this.codigoUnidadMedida = codigoUnidadMedida;
    }

    @Override
    public String toString() {
        return "Ingredientes{" + "codigoIngrediente=" + codigoIngrediente + ", codigoSucursal=" + codigoSucursal + ", codigoProveedor=" + codigoProveedor + ", nombreIngrediente=" + nombreIngrediente + ", cantidad=" + cantidad + ", codigoUnidadMedida=" + codigoUnidadMedida + '}';
    }

}
