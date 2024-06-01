/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Date;

/**
 *
 * @author Hp EliteBook
 */
public class Bonificacion {
    private int codigoBonificacion;
    private Date fechaBonificacion;
    private double montoBonificacion;
    private String motivoBonificacion;
    private int codigoEmpleado;

    public Bonificacion() {
    }

    public Bonificacion(int codigoBonificacion, Date fechaBonificacion, double montoBonificacion, String motivoBonificacion, int codigoEmpleado) {
        this.codigoBonificacion = codigoBonificacion;
        this.fechaBonificacion = fechaBonificacion;
        this.montoBonificacion = montoBonificacion;
        this.motivoBonificacion = motivoBonificacion;
        this.codigoEmpleado = codigoEmpleado;
    }

    /**
     * @return the codigoBonificacion
     */
    public int getCodigoBonificacion() {
        return codigoBonificacion;
    }

    /**
     * @param codigoBonificacion the codigoBonificacion to set
     */
    public void setCodigoBonificacion(int codigoBonificacion) {
        this.codigoBonificacion = codigoBonificacion;
    }

    /**
     * @return the fechaBonificacion
     */
    public Date getFechaBonificacion() {
        return fechaBonificacion;
    }

    /**
     * @param fechaBonificacion the fechaBonificacion to set
     */
    public void setFechaBonificacion(Date fechaBonificacion) {
        this.fechaBonificacion = fechaBonificacion;
    }

    /**
     * @return the montoBonificacion
     */
    public double getMontoBonificacion() {
        return montoBonificacion;
    }

    /**
     * @param montoBonificacion the montoBonificacion to set
     */
    public void setMontoBonificacion(double montoBonificacion) {
        this.montoBonificacion = montoBonificacion;
    }

    /**
     * @return the motivoBonificacion
     */
    public String getMotivoBonificacion() {
        return motivoBonificacion;
    }

    /**
     * @param motivoBonificacion the motivoBonificacion to set
     */
    public void setMotivoBonificacion(String motivoBonificacion) {
        this.motivoBonificacion = motivoBonificacion;
    }

    /**
     * @return the codigoEmpleado
     */
    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    /**
     * @param codigoEmpleado the codigoEmpleado to set
     */
    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    @Override
    public String toString() {
        return "Bonificaciones{" + "codigoBonificacion=" + 
                codigoBonificacion + ", fechaBonificacion=" + 
                fechaBonificacion + ", montoBonificacion=" +
                montoBonificacion + ", motivoBonificacion=" +
                motivoBonificacion + ", codigoEmpleado=" + codigoEmpleado + '}';
    }
    
}
