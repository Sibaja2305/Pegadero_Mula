/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesaauxiliar;

/**
 *
 * @author Usuario
 */
public class Impuesto {
    private int C_Impuesto;
    
   private String D_Impuesto;
    
    private int D_Procentaje_Impuesto;

    public Impuesto(int C_Impuesto, String D_Impuesto, int D_Procentaje_Impuesto) {
        this.C_Impuesto = C_Impuesto;
        this.D_Impuesto = D_Impuesto;
        this.D_Procentaje_Impuesto = D_Procentaje_Impuesto;
    }

    /**
     * @return the C_Impuesto
     */
    public int getC_Impuesto() {
        return C_Impuesto;
    }

    /**
     * @param C_Impuesto the C_Impuesto to set
     */
    public void setC_Impuesto(int C_Impuesto) {
        this.C_Impuesto = C_Impuesto;
    }

    /**
     * @return the D_Impuesto
     */
    public String getD_Impuesto() {
        return D_Impuesto;
    }

    /**
     * @param D_Impuesto the D_Impuesto to set
     */
    public void setD_Impuesto(String D_Impuesto) {
        this.D_Impuesto = D_Impuesto;
    }

    /**
     * @return the D_Procentaje_Impuesto
     */
    public int getD_Procentaje_Impuesto() {
        return D_Procentaje_Impuesto;
    }

    /**
     * @param D_Procentaje_Impuesto the D_Procentaje_Impuesto to set
     */
    public void setD_Procentaje_Impuesto(int D_Procentaje_Impuesto) {
        this.D_Procentaje_Impuesto = D_Procentaje_Impuesto;
    }

    @Override
    public String toString() {
        return "Impuesto{" + "C_Impuesto=" + C_Impuesto + ", D_Impuesto=" + D_Impuesto + ", D_Procentaje_Impuesto=" + D_Procentaje_Impuesto + '}';
    }
    
    
    
    
    
    
    
}
