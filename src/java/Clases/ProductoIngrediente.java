/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class ProductoIngrediente {
    private int codigoIngredientes;
    private int codigoProducto;
    private double cantidadConsumo;
    private int codigoUnidadMedida;

    public ProductoIngrediente() {
    }

    public ProductoIngrediente(int codigoIngredientes, int codigoProducto, double cantidadConsumo, int codigoUnidadMedida) {
        this.codigoIngredientes = codigoIngredientes;
        this.codigoProducto = codigoProducto;
        this.cantidadConsumo = cantidadConsumo;
        this.codigoUnidadMedida = codigoUnidadMedida;
    }

    /**
     * @return the codigoIngredientes
     */
    public int getCodigoIngredientes() {
        return codigoIngredientes;
    }

    /**
     * @param codigoIngredientes the codigoIngredientes to set
     */
    public void setCodigoIngredientes(int codigoIngredientes) {
        this.codigoIngredientes = codigoIngredientes;
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
     * @return the cantidadConsumo
     */
    public double getCantidadConsumo() {
        return cantidadConsumo;
    }

    /**
     * @param cantidadConsumo the cantidadConsumo to set
     */
    public void setCantidadConsumo(double cantidadConsumo) {
        this.cantidadConsumo = cantidadConsumo;
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
        return "ProductoIngrediente{" + "codigoIngredientes=" + codigoIngredientes 
                + ", codigoProducto=" + codigoProducto + ", cantidadConsumo=" 
                + cantidadConsumo + ", codigoUnidadMedida=" + codigoUnidadMedida + '}';
    }
    
}
