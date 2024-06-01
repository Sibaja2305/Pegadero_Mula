package Clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Mesa {
  private int  C_Mesa;
    
  private int  N_Mesa;
   
   private int N_Capacidad;

    public Mesa() {
    }

    public Mesa(int C_Mesa, int N_Mesa, int N_Capacidad) {
        this.C_Mesa = C_Mesa;
        this.N_Mesa = N_Mesa;
        this.N_Capacidad = N_Capacidad;
    }

    /**
     * @return the C_Mesa
     */
    public int getC_Mesa() {
        return C_Mesa;
    }

    /**
     * @param C_Mesa the C_Mesa to set
     */
    public void setC_Mesa(int C_Mesa) {
        this.C_Mesa = C_Mesa;
    }

    /**
     * @return the N_Mesa
     */
    public int getN_Mesa() {
        return N_Mesa;
    }

    /**
     * @param N_Mesa the N_Mesa to set
     */
    public void setN_Mesa(int N_Mesa) {
        this.N_Mesa = N_Mesa;
    }

    /**
     * @return the N_Capacidad
     */
    public int getN_Capacidad() {
        return N_Capacidad;
    }

    /**
     * @param N_Capacidad the N_Capacidad to set
     */
    public void setN_Capacidad(int N_Capacidad) {
        this.N_Capacidad = N_Capacidad;
    }

    @Override
    public String toString() {
        return "Mesa{" + "C_Mesa=" + C_Mesa + ", N_Mesa=" + N_Mesa + ", N_Capacidad=" + N_Capacidad + '}';
    }

    
    
    
    
    
}
