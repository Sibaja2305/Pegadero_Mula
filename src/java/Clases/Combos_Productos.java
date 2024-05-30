package clasesaauxiliar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Combos_Productos {
   private int C_Combo;
private int C_Producto;

    public Combos_Productos(int C_Combo, int C_Producto) {
        this.C_Combo = C_Combo;
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

    @Override
    public String toString() {
        return "Combos_Productos{" + "C_Combo=" + C_Combo + ", C_Producto=" + C_Producto + '}';
    }








}
