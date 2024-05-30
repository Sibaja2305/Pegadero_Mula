/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clasesaauxiliar;

/**
 *
 * @author Usuario
 */
public class Detalles_Pedido {
  private int  C_Detalle_Pedido;
   private int C_Pedido;
   private int C_Producto;
   private int Q_Pedido;
   private double M_Total;

    public Detalles_Pedido(int C_Detalle_Pedido, int C_Pedido, int C_Producto, int Q_Pedido, double M_Total) {
        this.C_Detalle_Pedido = C_Detalle_Pedido;
        this.C_Pedido = C_Pedido;
        this.C_Producto = C_Producto;
        this.Q_Pedido = Q_Pedido;
        this.M_Total = M_Total;
    }

    /**
     * @return the C_Detalle_Pedido
     */
    public int getC_Detalle_Pedido() {
        return C_Detalle_Pedido;
    }

    /**
     * @param C_Detalle_Pedido the C_Detalle_Pedido to set
     */
    public void setC_Detalle_Pedido(int C_Detalle_Pedido) {
        this.C_Detalle_Pedido = C_Detalle_Pedido;
    }

    /**
     * @return the C_Pedido
     */
    public int getC_Pedido() {
        return C_Pedido;
    }

    /**
     * @param C_Pedido the C_Pedido to set
     */
    public void setC_Pedido(int C_Pedido) {
        this.C_Pedido = C_Pedido;
    }

    /**
     * @return the C_Producto
     */
    public int getC_Producto() {
        return C_Producto;
    }

    /**
     * @param C_Producto the C_Producto to set
     */
    public void setC_Producto(int C_Producto) {
        this.C_Producto = C_Producto;
    }

    /**
     * @return the Q_Pedido
     */
    public int getQ_Pedido() {
        return Q_Pedido;
    }

    /**
     * @param Q_Pedido the Q_Pedido to set
     */
    public void setQ_Pedido(int Q_Pedido) {
        this.Q_Pedido = Q_Pedido;
    }

    /**
     * @return the M_Total
     */
    public double getM_Total() {
        return M_Total;
    }

    /**
     * @param M_Total the M_Total to set
     */
    public void setM_Total(double M_Total) {
        this.M_Total = M_Total;
    }

    @Override
    public String toString() {
        return "Detalles_Pedido{" + "C_Detalle_Pedido=" + C_Detalle_Pedido + ", C_Pedido=" + C_Pedido + ", C_Producto=" + C_Producto + ", Q_Pedido=" + Q_Pedido + ", M_Total=" + M_Total + '}';
    }
   
   
   
   
   
   
}
