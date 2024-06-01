/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class Producto {
    private int codigoProducto;
    private Integer codigoCombo;
    private int codigoSucursal;
    private int codigoTipoProducto;
    private String nombreProducto;
    private double precio;

    public Producto() {
    }

    public Producto(int codigoProducto, Integer codigoCombo, int codigoSucursal, int codigoTipoProducto, String nombreProducto, double precio) {
        this.codigoProducto = codigoProducto;
        this.codigoCombo = codigoCombo;
        this.codigoSucursal = codigoSucursal;
        this.codigoTipoProducto = codigoTipoProducto;
        this.nombreProducto = nombreProducto;
        this.precio = precio;
    }

    /**
     * @return the codigoProducto
     */
    public int getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the codigoCombo
     */
    public Integer getCodigoCombo() {
        return codigoCombo;
    }

    /**
     * @param codigoCombo the codigoCombo to set
     */
    public void setCodigoCombo(Integer codigoCombo) {
        this.codigoCombo = codigoCombo;
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
     * @return the codigoTipoProducto
     */
    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    /**
     * @param codigoTipoProducto the codigoTipoProducto to set
     */
    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProducto=" + codigoProducto + ", codigoCombo=" + codigoCombo + ", codigoSucursal=" + codigoSucursal + ", codigoTipoProducto=" + codigoTipoProducto + ", nombreProducto=" + nombreProducto + ", precio=" + precio + '}';
    }

   
    
}
