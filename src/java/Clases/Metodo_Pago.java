package clasesaauxiliar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Metodo_Pago {
 private int   C_Metodo_Pago;
  private String  D_Metodo_Pago;

    public Metodo_Pago(int C_Metodo_Pago, String D_Metodo_Pago) {
        this.C_Metodo_Pago = C_Metodo_Pago;
        this.D_Metodo_Pago = D_Metodo_Pago;
    }

    /**
     * @return the C_Metodo_Pago
     */
    public int getC_Metodo_Pago() {
        return C_Metodo_Pago;
    }

    /**
     * @param C_Metodo_Pago the C_Metodo_Pago to set
     */
    public void setC_Metodo_Pago(int C_Metodo_Pago) {
        this.C_Metodo_Pago = C_Metodo_Pago;
    }

    /**
     * @return the D_Metodo_Pago
     */
    public String getD_Metodo_Pago() {
        return D_Metodo_Pago;
    }

    /**
     * @param D_Metodo_Pago the D_Metodo_Pago to set
     */
    public void setD_Metodo_Pago(String D_Metodo_Pago) {
        this.D_Metodo_Pago = D_Metodo_Pago;
    }

    @Override
    public String toString() {
        return "Metodo_Pago{" + "C_Metodo_Pago=" + C_Metodo_Pago + ", D_Metodo_Pago=" + D_Metodo_Pago + '}';
    }
  
  
  
  
  
  
}
