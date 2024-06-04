package Clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Cliente {
    private int C_Cliente;
    private int C_Direccion_Fisica;
    private int C_Persona;
    private String N_Numero_Telefono;

    public Cliente() {
    }

    public Cliente(int C_Cliente, int C_Direccion_Fisica, int C_Persona, String N_Numero_Telefono) {
        this.C_Cliente = C_Cliente;
        this.C_Direccion_Fisica = C_Direccion_Fisica;
        this.C_Persona = C_Persona;
        this.N_Numero_Telefono = N_Numero_Telefono;
    }

    /**
     * @return the C_Cliente
     */
    public int getC_Cliente() {
        return C_Cliente;
    }

    /**
     * @param C_Cliente the C_Cliente to set
     */
    public void setC_Cliente(int C_Cliente) {
        this.C_Cliente = C_Cliente;
    }

    /**
     * @return the C_Direccion_Fisica
     */
    public int getC_Direccion_Fisica() {
        return C_Direccion_Fisica;
    }

    /**
     * @param C_Direccion_Fisica the C_Direccion_Fisica to set
     */
    public void setC_Direccion_Fisica(int C_Direccion_Fisica) {
        this.C_Direccion_Fisica = C_Direccion_Fisica;
    }

    /**
     * @return the C_Persona
     */
    public int getC_Persona() {
        return C_Persona;
    }

    /**
     * @param C_Persona the C_Persona to set
     */
    public void setC_Persona(int C_Persona) {
        this.C_Persona = C_Persona;
    }

    /**
     * @return the N_Numero_Telefono
     */
    public String getN_Numero_Telefono() {
        return N_Numero_Telefono;
    }

    /**
     * @param N_Numero_Telefono the N_Numero_Telefono to set
     */
    public void setN_Numero_Telefono(String N_Numero_Telefono) {
        this.N_Numero_Telefono = N_Numero_Telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "C_Cliente=" + C_Cliente 
                + ", C_Direccion_Fisica=" + C_Direccion_Fisica 
                + ", C_Persona=" + C_Persona + ", N_Numero_Telefono=" 
                + N_Numero_Telefono + '}';
    }

   

   

}