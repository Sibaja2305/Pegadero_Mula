/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Timestamp;

/**
 *
 * @author user
 */
public class VerFactura {

    private String DireccionFisica;
    private String Sucursal;
    private String Telefono;
    private String CorreoElectronico;
    private int CodigoFactura;
    private Timestamp FechaFactura;
    private String NombreCompleto;
    private int CodigoPedido;
    private String TipoImpuesto;
    private double CantidadImpuesto;
    private double Total;

    public VerFactura() {
    }

    public VerFactura(String DireccionFisica, String Sucursal, String Telefono,
            String CorreoElectronico, int CodigoFactura, Timestamp FechaFactura,
            String NombreCompleto, int CodigoPedido, String TipoImpuesto,
            double CantidadImpuesto, double Total) {
        
        this.DireccionFisica = DireccionFisica;
        this.Sucursal = Sucursal;
        this.Telefono = Telefono;
        this.CorreoElectronico = CorreoElectronico;
        this.CodigoFactura = CodigoFactura;
        this.FechaFactura = FechaFactura;
        this.NombreCompleto = NombreCompleto;
        this.CodigoPedido = CodigoPedido;
        this.TipoImpuesto = TipoImpuesto;
        this.CantidadImpuesto = CantidadImpuesto;
        this.Total = Total;
    }

    /**
     * @return the DireccionFisica
     */
    public String getDireccionFisica() {
        return DireccionFisica;
    }

    /**
     * @param DireccionFisica the DireccionFisica to set
     */
    public void setDireccionFisica(String DireccionFisica) {
        this.DireccionFisica = DireccionFisica;
    }

    /**
     * @return the Sucursal
     */
    public String getSucursal() {
        return Sucursal;
    }

    /**
     * @param Sucursal the Sucursal to set
     */
    public void setSucursal(String Sucursal) {
        this.Sucursal = Sucursal;
    }

    /**
     * @return the Telefono
     */
    public String getTelefono() {
        return Telefono;
    }

    /**
     * @param Telefono the Telefono to set
     */
    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    /**
     * @return the CorreoElectronico
     */
    public String getCorreoElectronico() {
        return CorreoElectronico;
    }

    /**
     * @param CorreoElectronico the CorreoElectronico to set
     */
    public void setCorreoElectronico(String CorreoElectronico) {
        this.CorreoElectronico = CorreoElectronico;
    }

    /**
     * @return the CodigoFactura
     */
    public int getCodigoFactura() {
        return CodigoFactura;
    }

    /**
     * @param CodigoFactura the CodigoFactura to set
     */
    public void setCodigoFactura(int CodigoFactura) {
        this.CodigoFactura = CodigoFactura;
    }

    /**
     * @return the FechaFactura
     */
    public Timestamp getFechaFactura() {
        return FechaFactura;
    }

    /**
     * @param FechaFactura the FechaFactura to set
     */
    public void setFechaFactura(Timestamp FechaFactura) {
        this.FechaFactura = FechaFactura;
    }

    /**
     * @return the NombreCompleto
     */
    public String getNombreCompleto() {
        return NombreCompleto;
    }

    /**
     * @param NombreCompleto the NombreCompleto to set
     */
    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    /**
     * @return the CodigoPedido
     */
    public int getCodigoPedido() {
        return CodigoPedido;
    }

    /**
     * @param CodigoPedido the CodigoPedido to set
     */
    public void setCodigoPedido(int CodigoPedido) {
        this.CodigoPedido = CodigoPedido;
    }

    /**
     * @return the TipoImpuesto
     */
    public String getTipoImpuesto() {
        return TipoImpuesto;
    }

    /**
     * @param TipoImpuesto the TipoImpuesto to set
     */
    public void setTipoImpuesto(String TipoImpuesto) {
        this.TipoImpuesto = TipoImpuesto;
    }

    /**
     * @return the Impuesto
     */
    public double getImpuesto() {
        return CantidadImpuesto;
    }

    /**
     * @param CantidadImpuesto
     */
    public void setImpuesto(double CantidadImpuesto) {
        this.CantidadImpuesto = CantidadImpuesto;
    }

    /**
     * @return the Total
     */
    public double getTotal() {
        return Total;
    }

    /**
     * @param Total the Total to set
     */
    public void setTotal(double Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "VerFactura{" + "DireccionFisica=" + DireccionFisica + ", Sucursal=" + Sucursal + ", Telefono=" + Telefono + ", CorreoElectronico=" + CorreoElectronico + ", CodigoFactura=" + CodigoFactura + ", FechaFactura=" + FechaFactura + ", NombreCompleto=" + NombreCompleto + ", CodigoPedido=" + CodigoPedido + ", TipoImpuesto=" + TipoImpuesto + ", CantidadImpuesto=" + CantidadImpuesto + ", Total=" + Total + '}';
    }
    

}
