/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Timestamp;

/**
 *
 * @author yorda
 */
public class Persona {
    private int C_Persona;
    private String C_Cedula;
    private String D_Nombre;
    private String D_Primer_Apellido;
    private String D_Segundo_Apellido;
    private Timestamp F_Fecha_Carga;

    public Persona() {
    }

    public Persona(int C_Persona, String C_Cedula, String D_Nombre, String D_Primer_Apellido, String D_Segundo_Apellido) {
        this.C_Persona = C_Persona;
        this.C_Cedula = C_Cedula;
        this.D_Nombre = D_Nombre;
        this.D_Primer_Apellido = D_Primer_Apellido;
        this.D_Segundo_Apellido = D_Segundo_Apellido;
    }

    /**
     * @return the C_Persona
     */
    public int getC_Persona() {
        return C_Persona;
    }

    /**
     * @param C_Persona the C_Persona to set
     */
    public void setC_Persona(int C_Persona) {
        this.C_Persona = C_Persona;
    }

    /**
     * @return the C_Cedula
     */
    public String getC_Cedula() {
        return C_Cedula;
    }

    /**
     * @param C_Cedula the C_Cedula to set
     */
    public void setC_Cedula(String C_Cedula) {
        this.C_Cedula = C_Cedula;
    }

    /**
     * @return the D_Nombre
     */
    public String getD_Nombre() {
        return D_Nombre;
    }

    /**
     * @param D_Nombre the D_Nombre to set
     */
    public void setD_Nombre(String D_Nombre) {
        this.D_Nombre = D_Nombre;
    }

    /**
     * @return the D_Primer_Apellido
     */
    public String getD_Primer_Apellido() {
        return D_Primer_Apellido;
    }

    /**
     * @param D_Primer_Apellido the D_Primer_Apellido to set
     */
    public void setD_Primer_Apellido(String D_Primer_Apellido) {
        this.D_Primer_Apellido = D_Primer_Apellido;
    }

    /**
     * @return the D_Segundo_Apellido
     */
    public String getD_Segundo_Apellido() {
        return D_Segundo_Apellido;
    }

    /**
     * @param D_Segundo_Apellido the D_Segundo_Apellido to set
     */
    public void setD_Segundo_Apellido(String D_Segundo_Apellido) {
        this.D_Segundo_Apellido = D_Segundo_Apellido;
    }

    /**
     * @return the F_Fecha_Carga
     */
    public Timestamp getF_Fecha_Carga() {
        return F_Fecha_Carga;
    }

    /**
     * @param F_Fecha_Carga the F_Fecha_Carga to set
     */
    public void setF_Fecha_Carga(Timestamp F_Fecha_Carga) {
        this.F_Fecha_Carga = F_Fecha_Carga;
    }

    @Override
    public String toString() {
        return "Persona{" + "C_Persona=" + C_Persona + ", C_Cedula=" + C_Cedula + ", D_Nombre=" + D_Nombre + ", D_Primer_Apellido=" + D_Primer_Apellido + ", D_Segundo_Apellido=" + D_Segundo_Apellido + ", F_Fecha_Carga=" + F_Fecha_Carga + '}';
    }
    
    
}
