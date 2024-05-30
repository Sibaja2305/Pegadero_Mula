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
public class Servicios {
    private int codigoServicio;
    private String nombreServicio;
    private Date fechaVencimiento;

    public Servicios() {
    }

    public Servicios(int codigoServicio, String nombreServicio, Date fechaVencimiento) {
        this.codigoServicio = codigoServicio;
        this.nombreServicio = nombreServicio;
        this.fechaVencimiento = fechaVencimiento;
    }

    /**
     * @return the codigoServicio
     */
    public int getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * @param codigoServicio the codigoServicio to set
     */
    public void setCodigoServicio(int codigoServicio) {
        this.codigoServicio = codigoServicio;
    }

    /**
     * @return the nombreServicio
     */
    public String getNombreServicio() {
        return nombreServicio;
    }

    /**
     * @param nombreServicio the nombreServicio to set
     */
    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    /**
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public String toString() {
        return "Servicios{" + "codigoServicio=" + codigoServicio + ", nombreServicio=" + nombreServicio + ", fechaVencimiento=" + fechaVencimiento + '}';
    }

    
    
}
