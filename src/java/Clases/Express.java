package Clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Express {
   private int C_Express;
   private String D_Nombre_Express;
 private String   D_Direccion_Cliente;

    public Express() {
    }

    public Express(int C_Express, String D_Nombre_Express, String D_Direccion_Cliente) {
        this.C_Express = C_Express;
        this.D_Nombre_Express = D_Nombre_Express;
        this.D_Direccion_Cliente = D_Direccion_Cliente;
    }

    /**
     * @return the C_Express
     */
    public int getC_Express() {
        return C_Express;
    }

    /**
     * @param C_Express the C_Express to set
     */
    public void setC_Express(int C_Express) {
        this.C_Express = C_Express;
    }

    /**
     * @return the D_Nombre_Express
     */
    public String getD_Nombre_Express() {
        return D_Nombre_Express;
    }

    /**
     * @param D_Nombre_Express the D_Nombre_Express to set
     */
    public void setD_Nombre_Express(String D_Nombre_Express) {
        this.D_Nombre_Express = D_Nombre_Express;
    }

    /**
     * @return the D_Direccion_Cliente
     */
    public String getD_Direccion_Cliente() {
        return D_Direccion_Cliente;
    }

    /**
     * @param D_Direccion_Cliente the D_Direccion_Cliente to set
     */
    public void setD_Direccion_Cliente(String D_Direccion_Cliente) {
        this.D_Direccion_Cliente = D_Direccion_Cliente;
    }

    @Override
    public String toString() {
        return "Express{" + "C_Express=" + C_Express + ", D_Nombre_Express=" + D_Nombre_Express + ", D_Direccion_Cliente=" + D_Direccion_Cliente + '}';
    }

    
    
    
    
}
