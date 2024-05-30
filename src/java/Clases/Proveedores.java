package clasesaauxiliar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Proveedores {
    private int C_Proveedor;
    private int C_Sucursal;
    private int D_Proveedor;

    public Proveedores(int C_Proveedor, int C_Sucursal, int D_Proveedor) {
        this.C_Proveedor = C_Proveedor;
        this.C_Sucursal = C_Sucursal;
        this.D_Proveedor = D_Proveedor;
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
     * @return the D_Proveedor
     */
    public int getD_Proveedor() {
        return D_Proveedor;
    }

    /**
     * @param D_Proveedor the D_Proveedor to set
     */
    public void setD_Proveedor(int D_Proveedor) {
        this.D_Proveedor = D_Proveedor;
    }

    @Override
    public String toString() {
        return "Proveedores{" + "C_Proveedor=" + C_Proveedor + ", C_Sucursal=" + C_Sucursal + ", D_Proveedor=" + D_Proveedor + '}';
    }
    
    
    
    
}
