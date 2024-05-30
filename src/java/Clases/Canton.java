/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class Canton {
    private int codigoCanton;
    private int codigoProvincia;
    private String nombreCanton;

    public Canton() {
    }

    public Canton(int codigoCanton, int codigoProvincia, String nombreCanton) {
        this.codigoCanton = codigoCanton;
        this.codigoProvincia = codigoProvincia;
        this.nombreCanton = nombreCanton;
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
     * @return the codigoProvincia
     */
    public int getCodigoProvincia() {
        return codigoProvincia;
    }

    /**
     * @param codigoProvincia the codigoProvincia to set
     */
    public void setCodigoProvincia(int codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    /**
     * @return the nombreCanton
     */
    public String getNombreCanton() {
        return nombreCanton;
    }

    /**
     * @param nombreCanton the nombreCanton to set
     */
    public void setNombreCanton(String nombreCanton) {
        this.nombreCanton = nombreCanton;
    }

    @Override
    public String toString() {
        return "Canton{" + "codigoCanton=" + codigoCanton + ", codigoProvincia=" 
                + codigoProvincia + ", nombreCanton=" + nombreCanton + '}';
    }
    
    
}
