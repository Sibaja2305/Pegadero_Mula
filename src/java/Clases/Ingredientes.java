/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesaauxiliar;

/**
 *
 * @author Usuario
 */
public class Ingredientes {
   private int C_Ingrediente;
  private int  C_Sucursal;
  private String  D_Ingrediente;
  private double  Q_Actual;
   private int C_Unidad_Medida;

    public Ingredientes(int C_Ingrediente, int C_Sucursal, String D_Ingrediente, double Q_Actual, int C_Unidad_Medida) {
        this.C_Ingrediente = C_Ingrediente;
        this.C_Sucursal = C_Sucursal;
        this.D_Ingrediente = D_Ingrediente;
        this.Q_Actual = Q_Actual;
        this.C_Unidad_Medida = C_Unidad_Medida;
    }

    /**
     * @return the C_Ingrediente
     */
    public int getC_Ingrediente() {
        return C_Ingrediente;
    }

    /**
     * @param C_Ingrediente the C_Ingrediente to set
     */
    public void setC_Ingrediente(int C_Ingrediente) {
        this.C_Ingrediente = C_Ingrediente;
    }

    /**
     * @return the C_Sucursal
     */
    public int getC_Sucursal() {
        return C_Sucursal;
    }

    /**
     * @param C_Sucursal the C_Sucursal to set
     */
    public void setC_Sucursal(int C_Sucursal) {
        this.C_Sucursal = C_Sucursal;
    }

    /**
     * @return the D_Ingrediente
     */
    public String getD_Ingrediente() {
        return D_Ingrediente;
    }

    /**
     * @param D_Ingrediente the D_Ingrediente to set
     */
    public void setD_Ingrediente(String D_Ingrediente) {
        this.D_Ingrediente = D_Ingrediente;
    }

    /**
     * @return the Q_Actual
     */
    public double getQ_Actual() {
        return Q_Actual;
    }

    /**
     * @param Q_Actual the Q_Actual to set
     */
    public void setQ_Actual(double Q_Actual) {
        this.Q_Actual = Q_Actual;
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
        return "Ingredientes{" + "C_Ingrediente=" + C_Ingrediente + ", C_Sucursal=" + C_Sucursal + ", D_Ingrediente=" + D_Ingrediente + ", Q_Actual=" + Q_Actual + ", C_Unidad_Medida=" + C_Unidad_Medida + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
