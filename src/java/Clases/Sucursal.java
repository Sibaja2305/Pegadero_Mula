/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class Sucursal {
    private int codigoSucursal;
    private String nombreSucursal;
    private String telefono;
    private String correoElectronico;
    private int codigoDireccionFisica;

    public Sucursal() {
    }

    public Sucursal(int codigoSucursal, String nombreSucursal, String telefono, String correoElectronico, int codigoDireccionFisica) {
        this.codigoSucursal = codigoSucursal;
        this.nombreSucursal = nombreSucursal;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.codigoDireccionFisica = codigoDireccionFisica;
    }

    /**
     * @return the codigoSucursal
     */
    public int getCodigoSucursal() {
        return codigoSucursal;
    }

    /**
     * @param codigoSucursal the codigoSucursal to set
     */
    public void setCodigoSucursal(int codigoSucursal) {
        this.codigoSucursal = codigoSucursal;
    }

    /**
     * @return the nombreSucursal
     */
    public String getNombreSucursal() {
        return nombreSucursal;
    }

    /**
     * @param nombreSucursal the nombreSucursal to set
     */
    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the correoElectronico
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico the correoElectronico to set
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return the codigoDireccionFisica
     */
    public int getCodigoDireccionFisica() {
        return codigoDireccionFisica;
    }

    /**
     * @param codigoDireccionFisica the codigoDireccionFisica to set
     */
    public void setCodigoDireccionFisica(int codigoDireccionFisica) {
        this.codigoDireccionFisica = codigoDireccionFisica;
    }

    @Override
    public String toString() {
        return "Sucursal{" + "codigoSucursal=" + codigoSucursal 
                + ", nombreSucursal=" + nombreSucursal + ", telefono=" 
                + telefono + ", correoElectronico=" + correoElectronico 
                + ", codigoDireccionFisica=" + codigoDireccionFisica + '}';
    }
    
}
