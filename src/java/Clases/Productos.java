package clasesaauxiliar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Productos {
    
    private int C_Producto;
    private int C_Combo;
    private int C_Sucursal;
    private int C_Tipo_Producto;
    private String D_Producto;
    private double M_Precio;

    public Productos(int C_Producto, int C_Combo, int C_Sucursal, int C_Tipo_Producto, String D_Producto, double M_Precio) {
        this.C_Producto = C_Producto;
        this.C_Combo = C_Combo;
        this.C_Sucursal = C_Sucursal;
        this.C_Tipo_Producto = C_Tipo_Producto;
        this.D_Producto = D_Producto;
        this.M_Precio = M_Precio;
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
     * @return the C_Combo
     */
    public int getC_Combo() {
        return C_Combo;
    }

    /**
     * @param C_Combo the C_Combo to set
     */
    public void setC_Combo(int C_Combo) {
        this.C_Combo = C_Combo;
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
     * @return the C_Tipo_Producto
     */
    public int getC_Tipo_Producto() {
        return C_Tipo_Producto;
    }

    /**
     * @param C_Tipo_Producto the C_Tipo_Producto to set
     */
    public void setC_Tipo_Producto(int C_Tipo_Producto) {
        this.C_Tipo_Producto = C_Tipo_Producto;
    }

    /**
     * @return the D_Producto
     */
    public String getD_Producto() {
        return D_Producto;
    }

    /**
     * @param D_Producto the D_Producto to set
     */
    public void setD_Producto(String D_Producto) {
        this.D_Producto = D_Producto;
    }

    /**
     * @return the M_Precio
     */
    public double getM_Precio() {
        return M_Precio;
    }

    /**
     * @param M_Precio the M_Precio to set
     */
    public void setM_Precio(double M_Precio) {
        this.M_Precio = M_Precio;
    }

    @Override
    public String toString() {
        return "Productos{" + "C_Producto=" + C_Producto + ", C_Combo=" + C_Combo + ", C_Sucursal=" + C_Sucursal + ", C_Tipo_Producto=" + C_Tipo_Producto + ", D_Producto=" + D_Producto + ", M_Precio=" + M_Precio + '}';
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
}
