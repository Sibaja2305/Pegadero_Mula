/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class UnidadMedida {
    private int codigoUnidadMedida;
    private String unidadMedidad;
    private double cantidaUnidadMedida;

    public UnidadMedida() {
    }

    public UnidadMedida(int codigoUnidadMedida, String unidadMedidad, double cantidaUnidadMedida) {
        this.codigoUnidadMedida = codigoUnidadMedida;
        this.unidadMedidad = unidadMedidad;
        this.cantidaUnidadMedida = cantidaUnidadMedida;
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

    /**
     * @return the unidadMedidad
     */
    public String getUnidadMedidad() {
        return unidadMedidad;
    }

    /**
     * @param unidadMedidad the unidadMedidad to set
     */
    public void setUnidadMedidad(String unidadMedidad) {
        this.unidadMedidad = unidadMedidad;
    }

    /**
     * @return the cantidaUnidadMedida
     */
    public double getCantidaUnidadMedida() {
        return cantidaUnidadMedida;
    }

    /**
     * @param cantidaUnidadMedida the cantidaUnidadMedida to set
     */
    public void setCantidaUnidadMedida(double cantidaUnidadMedida) {
        this.cantidaUnidadMedida = cantidaUnidadMedida;
    }

    @Override
    public String toString() {
        return "UnidadMedida{" + "codigoUnidadMedida=" + codigoUnidadMedida 
                + ", unidadMedidad=" + unidadMedidad + ", cantidaUnidadMedida=" 
                + cantidaUnidadMedida + '}';
    }
    
}
