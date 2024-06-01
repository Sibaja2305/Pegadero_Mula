package Clases;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class ClientesSucursales {
    private int cCliente;
    private int cSucursales;

    public ClientesSucursales() {
    }

    public ClientesSucursales(int cCliente, int cSucursales) {
        this.cCliente = cCliente;
        this.cSucursales = cSucursales;
    }
    

   

    /**
     * @return the cCliente
     */
    public int getcCliente() {
        return cCliente;
    }

    /**
     * @param cCliente the cCliente to set
     */
    public void setcCliente(int cCliente) {
        this.cCliente = cCliente;
    }

    /**
     * @return the cSucursales
     */
    public int getcSucursales() {
        return cSucursales;
    }

    /**
     * @param cSucursales the cSucursales to set
     */
    public void setcSucursales(int cSucursales) {
        this.cSucursales = cSucursales;
    }

    @Override
    public String toString() {
        return "Clientes_Sucursales{" + "cCliente=" + cCliente + ", cSucursales=" + cSucursales + '}';
    }

    
    
    
}
