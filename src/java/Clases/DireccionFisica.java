/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class DireccionFisica {
    private int codigoDireccionFisica;
    private int codigoDistrito;
    private String nombreDireccionFisica;

    public DireccionFisica() {
    }

    public DireccionFisica(int codigoDireccionFisica, int codigoDistrito, String nombreDireccionFisica) {
        this.codigoDireccionFisica = codigoDireccionFisica;
        this.codigoDistrito = codigoDistrito;
        this.nombreDireccionFisica = nombreDireccionFisica;
    }

    /**
     * @return the codigoDireccionFisica
     */
    public int getCodigoDireccionFisica() {
        return codigoDireccionFisica;
    }

    /**
     * @param codigoDireccionFisica the codigoDireccionFisica to set
     */
    public void setCodigoDireccionFisica(int codigoDireccionFisica) {
        this.codigoDireccionFisica = codigoDireccionFisica;
    }

    /**
     * @return the codigoDistrito
     */
    public int getCodigoDistrito() {
        return codigoDistrito;
    }

    /**
     * @param codigoDistrito the codigoDistrito to set
     */
    public void setCodigoDistrito(int codigoDistrito) {
        this.codigoDistrito = codigoDistrito;
    }

    /**
     * @return the nombreDireccionFisica
     */
    public String getNombreDireccionFisica() {
        return nombreDireccionFisica;
    }

    /**
     * @param nombreDireccionFisica the nombreDireccionFisica to set
     */
    public void setNombreDireccionFisica(String nombreDireccionFisica) {
        this.nombreDireccionFisica = nombreDireccionFisica;
    }

    @Override
    public String toString() {
        return "Direccion_Fisica{" + "codigoDireccionFisica=" +
                codigoDireccionFisica + ", codigoDistrito=" + codigoDistrito 
                + ", nombreDireccionFisica=" + nombreDireccionFisica + '}';
    }
    
}
