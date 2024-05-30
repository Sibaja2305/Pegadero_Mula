package clasesaauxiliar;

                /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Pagos_Proveedores {
    
    private int C_Pago_Proveedor;
    
     private int C_Proveedor;
    
    private double M_Pago_Proveedor;

    public Pagos_Proveedores(int C_Pago_Proveedor, int C_Proveedor, double M_Pago_Proveedor) {
        this.C_Pago_Proveedor = C_Pago_Proveedor;
        this.C_Proveedor = C_Proveedor;
        this.M_Pago_Proveedor = M_Pago_Proveedor;
    }

    /**
     * @return the C_Pago_Proveedor
     */
    public int getC_Pago_Proveedor() {
        return C_Pago_Proveedor;
    }

    /**
     * @param C_Pago_Proveedor the C_Pago_Proveedor to set
     */
    public void setC_Pago_Proveedor(int C_Pago_Proveedor) {
        this.C_Pago_Proveedor = C_Pago_Proveedor;
    }

    /**
     * @return the C_Proveedor
     */
    public int getC_Proveedor() {
        return C_Proveedor;
    }

    /**
     * @param C_Proveedor the C_Proveedor to set
     */
    public void setC_Proveedor(int C_Proveedor) {
        this.C_Proveedor = C_Proveedor;
    }

    /**
     * @return the M_Pago_Proveedor
     */
    public double getM_Pago_Proveedor() {
        return M_Pago_Proveedor;
    }

    /**
     * @param M_Pago_Proveedor the M_Pago_Proveedor to set
     */
    public void setM_Pago_Proveedor(double M_Pago_Proveedor) {
        this.M_Pago_Proveedor = M_Pago_Proveedor;
    }

    @Override
    public String toString() {
        return "Pagos_Proveedores{" + "C_Pago_Proveedor=" + C_Pago_Proveedor + ", C_Proveedor=" + C_Proveedor + ", M_Pago_Proveedor=" + M_Pago_Proveedor + '}';
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
