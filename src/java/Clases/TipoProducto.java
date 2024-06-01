/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class TipoProducto {
    private int codigoTipoProducto;
    private String tipoProducto;

    public TipoProducto() {
    }

    public TipoProducto(int codigoTipoProducto, String tipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
        this.tipoProducto = tipoProducto;
    }

    /**
     * @return the codigoTipoProducto
     */
    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    /**
     * @param codigoTipoProducto the codigoTipoProducto to set
     */
    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    /**
     * @return the tipoProducto
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    @Override
    public String toString() {
        return "TipoProducto{" + "codigoTipoProducto=" + codigoTipoProducto + ", tipoProducto=" + tipoProducto + '}';
    }
    
}
