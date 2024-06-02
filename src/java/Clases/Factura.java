/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Timestamp;

/**
 *
 * @author Usuario
 */
public class Factura {

    private int C_Factura;
    private int C_Pedido;
    private int C_Metodo_Pago;
    private int C_Sucursal;
    private int C_Impuesto;
    private Timestamp F_Factura;
    private double M_Total;

    public Factura() {
    }

    public Factura(int C_Factura, int C_Pedido, int C_Metodo_Pago, int C_Sucursal, int C_Impuesto, Timestamp F_Factura, double M_Total) {
        this.C_Factura = C_Factura;
        this.C_Pedido = C_Pedido;
        this.C_Metodo_Pago = C_Metodo_Pago;
        this.C_Sucursal = C_Sucursal;
        this.C_Impuesto = C_Impuesto;
        this.F_Factura = F_Factura;
        this.M_Total = M_Total;
    }

    /**
     * @return the C_Factura
     */
    public int getC_Factura() {
        return C_Factura;
    }

    /**
     * @param C_Factura the C_Factura to set
     */
    public void setC_Factura(int C_Factura) {
        this.C_Factura = C_Factura;
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
     * @return the F_Factura
     */
    public Timestamp getF_Factura() {
        return F_Factura;
    }

    /**
     * @param F_Factura the F_Factura to set
     */
    public void setF_Factura(Timestamp F_Factura) {
        this.F_Factura = F_Factura;
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
        return "Factura{" + "C_Factura=" + C_Factura + ", C_Pedido=" + C_Pedido + ", C_Metodo_Pago=" + C_Metodo_Pago + ", C_Sucursal=" + C_Sucursal + ", C_Impuesto=" + C_Impuesto + ", F_Factura=" + F_Factura + ", M_Total=" + M_Total + '}';
    }

}
