/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class Proveedor {
  private int codigoProveedor;
  private int codigoSucursal;
  private String proveedor;

    public Proveedor() {
    }

    public Proveedor(int codigoProveedor, int codigoSucursal, String proveedor) {
        this.codigoProveedor = codigoProveedor;
        this.codigoSucursal = codigoSucursal;
        this.proveedor = proveedor;
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
     * @return the proveedor
     */
    public String getProveedor() {
        return proveedor;
    }

    /**
     * @param proveedor the proveedor to set
     */
    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "codigoProveedor=" + codigoProveedor 
                + ", codigoSucursal=" + codigoSucursal + ", proveedor=" + proveedor + '}';
    }
  
}
