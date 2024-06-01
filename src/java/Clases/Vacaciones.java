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
public class Vacaciones {
    private int codigoVacaciones;
    private int codigoEmpleado;
    private Date FechaInicio;
    private Date FechaFin;

    public Vacaciones() {
    }

    public Vacaciones(int codigoVacaciones, int codigoEmpleado, Date FechaInicio, Date FechaFin) {
        this.codigoVacaciones = codigoVacaciones;
        this.codigoEmpleado = codigoEmpleado;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }

    /**
     * @return the codigoVacaciones
     */
    public int getCodigoVacaciones() {
        return codigoVacaciones;
    }

    /**
     * @param codigoVacaciones the codigoVacaciones to set
     */
    public void setCodigoVacaciones(int codigoVacaciones) {
        this.codigoVacaciones = codigoVacaciones;
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

    /**
     * @return the FechaInicio
     */
    public Date getFechaInicio() {
        return FechaInicio;
    }

    /**
     * @param FechaInicio the FechaInicio to set
     */
    public void setFechaInicio(Date FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    /**
     * @return the FechaFin
     */
    public Date getFechaFin() {
        return FechaFin;
    }

    /**
     * @param FechaFin the FechaFin to set
     */
    public void setFechaFin(Date FechaFin) {
        this.FechaFin = FechaFin;
    }

    @Override
    public String toString() {
        return "Vacaciones{" + "codigoVacaciones=" + codigoVacaciones +
                ", codigoEmpleado=" + codigoEmpleado + ", FechaInicio=" 
                + FechaInicio + ", FechaFin=" + FechaFin + '}';
    }
    
}
