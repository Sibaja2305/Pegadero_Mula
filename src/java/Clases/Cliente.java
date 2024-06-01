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
    private String C_Cedula;
    private String N_Numero_Telefono;

    public Cliente() {
    }

    public Cliente(int C_Cliente, int C_Direccion_Fisica, String C_Cedula, String N_Numero_Telefono) {
        this.C_Cliente = C_Cliente;
        this.C_Direccion_Fisica = C_Direccion_Fisica;
        this.C_Cedula = C_Cedula;
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
     * @return the C_Cedula
     */
    public String getC_Cedula() {
        return C_Cedula;
    }

    /**
     * @param C_Cedula the C_Cedula to set
     */
    public void setC_Cedula(String C_Cedula) {
        this.C_Cedula = C_Cedula;
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
        return "Clientes{" + "C_Cliente=" + C_Cliente + ", C_Direccion_Fisica=" +
                C_Direccion_Fisica + ", C_Cedula=" + C_Cedula + ", N_Numero_Telefono=" + N_Numero_Telefono + '}';
    }

   

}