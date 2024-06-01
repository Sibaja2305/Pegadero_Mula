/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class Combo {
    private int CodigoCombo;
    private String nombreCombo;

    public Combo() {
    }

    public Combo(int CodigoCombo, String nombreCombo) {
        this.CodigoCombo = CodigoCombo;
        this.nombreCombo = nombreCombo;
    }

    /**
     * @return the CodigoCombo
     */
    public int getCodigoCombo() {
        return CodigoCombo;
    }

    /**
     * @param CodigoCombo the CodigoCombo to set
     */
    public void setCodigoCombo(int CodigoCombo) {
        this.CodigoCombo = CodigoCombo;
    }

    /**
     * @return the nombreCombo
     */
    public String getNombreCombo() {
        return nombreCombo;
    }

    /**
     * @param nombreCombo the nombreCombo to set
     */
    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    @Override
    public String toString() {
        return "Combo{" + "CodigoCombo=" + CodigoCombo + ", nombreCombo=" + nombreCombo + '}';
    }
    
}
