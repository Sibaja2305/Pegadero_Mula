package clasesaauxiliar;


import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Bonificaciones {
private int C_Bonificacion;
private Date F_Bonificacion;
private double M_Bonificacion;
private String D_Motivo;
private int C_Empleado;

    public Bonificaciones(int C_Bonificacion, Date F_Bonificacion, double M_Bonificacion, String D_Motivo, int C_Empleado) {
        this.C_Bonificacion = C_Bonificacion;
        this.F_Bonificacion = F_Bonificacion;
        this.M_Bonificacion = M_Bonificacion;
        this.D_Motivo = D_Motivo;
        this.C_Empleado = C_Empleado;
    }

    /**
     * @return the C_Bonificacion
     */
    public int getC_Bonificacion() {
        return C_Bonificacion;
    }

    /**
     * @param C_Bonificacion the C_Bonificacion to set
     */
    public void setC_Bonificacion(int C_Bonificacion) {
        this.C_Bonificacion = C_Bonificacion;
    }

    /**
     * @return the F_Bonificacion
     */
    public Date getF_Bonificacion() {
        return F_Bonificacion;
    }

    /**
     * @param F_Bonificacion the F_Bonificacion to set
     */
    public void setF_Bonificacion(Date F_Bonificacion) {
        this.F_Bonificacion = F_Bonificacion;
    }

    /**
     * @return the M_Bonificacion
     */
    public double getM_Bonificacion() {
        return M_Bonificacion;
    }

    /**
     * @param M_Bonificacion the M_Bonificacion to set
     */
    public void setM_Bonificacion(double M_Bonificacion) {
        this.M_Bonificacion = M_Bonificacion;
    }

    /**
     * @return the D_Motivo
     */
    public String getD_Motivo() {
        return D_Motivo;
    }

    /**
     * @param D_Motivo the D_Motivo to set
     */
    public void setD_Motivo(String D_Motivo) {
        this.D_Motivo = D_Motivo;
    }

    /**
     * @return the C_Empleado
     */
    public int getC_Empleado() {
        return C_Empleado;
    }

    /**
     * @param C_Empleado the C_Empleado to set
     */
    public void setC_Empleado(int C_Empleado) {
        this.C_Empleado = C_Empleado;
    }

    @Override
    public String toString() {
        return "Bonificaciones{" + "C_Bonificacion=" + C_Bonificacion + ", F_Bonificacion=" + F_Bonificacion + ", M_Bonificacion=" + M_Bonificacion + ", D_Motivo=" + D_Motivo + ", C_Empleado=" + C_Empleado + '}';
    }


}
