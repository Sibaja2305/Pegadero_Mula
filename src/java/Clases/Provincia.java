/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Kevin Sibaja Granados
 */
public class Provincia {
    private int CodigoProvincia;
    private String NombreProvincia;

    public Provincia() {
    }

    public Provincia(int CodigoProvincia, String NombreProvincia) {
        this.CodigoProvincia = CodigoProvincia;
        this.NombreProvincia = NombreProvincia;
    }

    /**
     * @return the CodigoProvincia
     */
    public int getCodigoProvincia() {
        return CodigoProvincia;
    }

    /**
     * @param CodigoProvincia the CodigoProvincia to set
     */
    public void setCodigoProvincia(int CodigoProvincia) {
        this.CodigoProvincia = CodigoProvincia;
    }

    /**
     * @return the NombreProvincia
     */
    public String getNombreProvincia() {
        return NombreProvincia;
    }

    /**
     * @param NombreProvincia the NombreProvincia to set
     */
    public void setNombreProvincia(String NombreProvincia) {
        this.NombreProvincia = NombreProvincia;
    }

    @Override
    public String toString() {
        return "Provincia{" + "CodigoProvincia=" + CodigoProvincia 
                + ", NombreProvincia=" + NombreProvincia + '}';
    }
    
}
