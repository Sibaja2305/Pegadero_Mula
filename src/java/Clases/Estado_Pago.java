/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesaauxiliar;

/**
 *
 * @author Usuario
 */
public class Estado_Pago {
   private int C_Estado_Pago;
   private String D_Estado;

    public Estado_Pago(int C_Estado_Pago, String D_Estado) {
        this.C_Estado_Pago = C_Estado_Pago;
        this.D_Estado = D_Estado;
    }

    /**
     * @return the C_Estado_Pago
     */
    public int getC_Estado_Pago() {
        return C_Estado_Pago;
    }

    /**
     * @param C_Estado_Pago the C_Estado_Pago to set
     */
    public void setC_Estado_Pago(int C_Estado_Pago) {
        this.C_Estado_Pago = C_Estado_Pago;
    }

    /**
     * @return the D_Estado
     */
    public String getD_Estado() {
        return D_Estado;
    }

    /**
     * @param D_Estado the D_Estado to set
     */
    public void setD_Estado(String D_Estado) {
        this.D_Estado = D_Estado;
    }

    @Override
    public String toString() {
        return "Estado_Pago{" + "C_Estado_Pago=" + C_Estado_Pago + ", D_Estado=" + D_Estado + '}';
    }
   
   
   
   
   
   
   
   
}
