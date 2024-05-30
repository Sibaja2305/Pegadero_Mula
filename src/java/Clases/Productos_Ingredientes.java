package clasesaauxiliar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Productos_Ingredientes {

    
    
   private int C_Ingredientes;
    private int C_Productos;
    private double Q_Consumo;
    
    private int C_Unidad_Medida;

    public Productos_Ingredientes(int C_Ingredientes, int C_Productos, double Q_Consumo, int C_Unidad_Medida) {
        this.C_Ingredientes = C_Ingredientes;
        this.C_Productos = C_Productos;
        this.Q_Consumo = Q_Consumo;
        this.C_Unidad_Medida = C_Unidad_Medida;
    }

    /**
     * @return the C_Ingredientes
     */
    public int getC_Ingredientes() {
        return C_Ingredientes;
    }

    /**
     * @param C_Ingredientes the C_Ingredientes to set
     */
    public void setC_Ingredientes(int C_Ingredientes) {
        this.C_Ingredientes = C_Ingredientes;
    }

    /**
     * @return the C_Productos
     */
    public int getC_Productos() {
        return C_Productos;
    }

    /**
     * @param C_Productos the C_Productos to set
     */
    public void setC_Productos(int C_Productos) {
        this.C_Productos = C_Productos;
    }

    /**
     * @return the Q_Consumo
     */
    public double getQ_Consumo() {
        return Q_Consumo;
    }

    /**
     * @param Q_Consumo the Q_Consumo to set
     */
    public void setQ_Consumo(double Q_Consumo) {
        this.Q_Consumo = Q_Consumo;
    }

    /**
     * @return the C_Unidad_Medida
     */
    public int getC_Unidad_Medida() {
        return C_Unidad_Medida;
    }

    /**
     * @param C_Unidad_Medida the C_Unidad_Medida to set
     */
    public void setC_Unidad_Medida(int C_Unidad_Medida) {
        this.C_Unidad_Medida = C_Unidad_Medida;
    }

    @Override
    public String toString() {
        return "Productos_Ingredientes{" + "C_Ingredientes=" + C_Ingredientes + ", C_Productos=" + C_Productos + ", Q_Consumo=" + Q_Consumo + ", C_Unidad_Medida=" + C_Unidad_Medida + '}';
    }
    
    
    
    
    
    
    
    
}
