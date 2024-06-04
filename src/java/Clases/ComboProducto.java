/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class ComboProducto {
    private int codigoProducto;
    private int codigoCombo;

    public ComboProducto() {
    }

    public ComboProducto(int codigoProducto, int codigoCombo) {
        this.codigoProducto = codigoProducto;
        this.codigoCombo = codigoCombo;
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
    public int getCodigoCombo() {
        return codigoCombo;
    }

    /**
     * @param codigoCombo the codigoCombo to set
     */
    public void setCodigoCombo(int codigoCombo) {
        this.codigoCombo = codigoCombo;
    }

    @Override
    public String toString() {
        return "ComboProducto{" + "codigoProducto=" + codigoProducto + ", codigoCombo=" + codigoCombo + '}';
    }
    
}
