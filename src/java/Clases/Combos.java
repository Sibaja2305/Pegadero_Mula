package clasesaauxiliar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Combos {
    
    
    
    private int C_Combo;
    private String D_Combo;

    public Combos(int C_Combo, String D_Combo) {
        this.C_Combo = C_Combo;
        this.D_Combo = D_Combo;
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
     * @return the D_Combo
     */
    public String getD_Combo() {
        return D_Combo;
    }

    /**
     * @param D_Combo the D_Combo to set
     */
    public void setD_Combo(String D_Combo) {
        this.D_Combo = D_Combo;
    }

    @Override
    public String toString() {
        return "Combos{" + "C_Combo=" + C_Combo + ", D_Combo=" + D_Combo + '}';
    }
    
    
    
}
