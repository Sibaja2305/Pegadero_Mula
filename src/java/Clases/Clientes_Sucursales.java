package clasesaauxiliar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Clientes_Sucursales {
    private int C_Cliente;
    private int C_Sucursales;

    public Clientes_Sucursales(int C_Cliente, int C_Sucursales) {
        this.C_Cliente = C_Cliente;
        this.C_Sucursales = C_Sucursales;
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
     * @return the C_Sucursales
     */
    public int getC_Sucursales() {
        return C_Sucursales;
    }

    /**
     * @param C_Sucursales the C_Sucursales to set
     */
    public void setC_Sucursales(int C_Sucursales) {
        this.C_Sucursales = C_Sucursales;
    }

    @Override
    public String toString() {
        return "Clientes_Sucursales{" + "C_Cliente=" + C_Cliente + ", C_Sucursales=" + C_Sucursales + '}';
    }
    
    
    
    
    
}
