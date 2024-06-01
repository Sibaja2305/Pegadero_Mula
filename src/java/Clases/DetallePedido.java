/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class DetallePedido {
    private int codigoDetallePedido;
    private int codigoPedido;
    private int codigoProducto;
    private String nombreProducto;
    private int cantidadProducto;
    private double montoTotal;

    public DetallePedido() {
    }

    public DetallePedido(int codigoDetallePedido, int codigoPedido, int codigoProducto, String nombreProducto, int cantidadProducto, double montoTotal) {
        this.codigoDetallePedido = codigoDetallePedido;
        this.codigoPedido = codigoPedido;
        this.codigoProducto = codigoProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.montoTotal = montoTotal;
    }

    /**
     * @return the codigoDetallePedido
     */
    public int getCodigoDetallePedido() {
        return codigoDetallePedido;
    }

    /**
     * @param codigoDetallePedido the codigoDetallePedido to set
     */
    public void setCodigoDetallePedido(int codigoDetallePedido) {
        this.codigoDetallePedido = codigoDetallePedido;
    }

    /**
     * @return the codigoPedido
     */
    public int getCodigoPedido() {
        return codigoPedido;
    }

    /**
     * @param codigoPedido the codigoPedido to set
     */
    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    /**
     * @return the codigoProducto
     */
    public int getCodigoProducto() {
        return codigoProducto;
    }

    /**
     * @param codigoProducto the codigoProducto to set
     */
    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the cantidadProducto
     */
    public int getCantidadProducto() {
        return cantidadProducto;
    }

    /**
     * @param cantidadProducto the cantidadProducto to set
     */
    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    /**
     * @return the montoTotal
     */
    public double getMontoTotal() {
        return montoTotal;
    }

    /**
     * @param montoTotal the montoTotal to set
     */
    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @Override
    public String toString() {
        return "DetallePedido{" + "codigoDetallePedido=" + codigoDetallePedido + ", codigoPedido=" + codigoPedido + ", codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto + ", cantidadProducto=" + cantidadProducto + ", montoTotal=" + montoTotal + '}';
    }

    
    
}
