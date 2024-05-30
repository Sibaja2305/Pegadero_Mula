/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class Distrito {
    private int codigoDistrito;
    private int codigoCanton;
    private String nombreDistrito;

    public Distrito() {
    }

    public Distrito(int codigoDistrito, int codigoCanton, String nombreDistrito) {
        this.codigoDistrito = codigoDistrito;
        this.codigoCanton = codigoCanton;
        this.nombreDistrito = nombreDistrito;
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
     * @return the codigoCanton
     */
    public int getCodigoCanton() {
        return codigoCanton;
    }

    /**
     * @param codigoCanton the codigoCanton to set
     */
    public void setCodigoCanton(int codigoCanton) {
        this.codigoCanton = codigoCanton;
    }

    /**
     * @return the nombreDistrito
     */
    public String getNombreDistrito() {
        return nombreDistrito;
    }

    /**
     * @param nombreDistrito the nombreDistrito to set
     */
    public void setNombreDistrito(String nombreDistrito) {
        this.nombreDistrito = nombreDistrito;
    }

    @Override
    public String toString() {
        return "Distrito{" + "codigoDistrito=" + codigoDistrito + ", codigoCanton=" + codigoCanton + ", nombreDistrito=" + nombreDistrito + '}';
    }
    
}
