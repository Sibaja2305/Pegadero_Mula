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
public class Pagos_Empleados {
  private int  C_Pago_Empleado ;
   private int C_Empleado;
   private int C_Horas_Extra;
    
  private int  C_Estado_Pago;
  private Date F_Emision;
   private Date F_Pago;
   private double M_Pago;
   private double M_Pago_CCSS;
   private int C_Bonificacion;

    public Pagos_Empleados(int C_Pago_Empleado, int C_Empleado, int C_Horas_Extra, int C_Estado_Pago, Date F_Emision, Date F_Pago, double M_Pago, double M_Pago_CCSS, int C_Bonificacion) {
        this.C_Pago_Empleado = C_Pago_Empleado;
        this.C_Empleado = C_Empleado;
        this.C_Horas_Extra = C_Horas_Extra;
        this.C_Estado_Pago = C_Estado_Pago;
        this.F_Emision = F_Emision;
        this.F_Pago = F_Pago;
        this.M_Pago = M_Pago;
        this.M_Pago_CCSS = M_Pago_CCSS;
        this.C_Bonificacion = C_Bonificacion;
    }

    /**
     * @return the C_Pago_Empleado
     */
    public int getC_Pago_Empleado() {
        return C_Pago_Empleado;
    }

    /**
     * @param C_Pago_Empleado the C_Pago_Empleado to set
     */
    public void setC_Pago_Empleado(int C_Pago_Empleado) {
        this.C_Pago_Empleado = C_Pago_Empleado;
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

    /**
     * @return the C_Horas_Extra
     */
    public int getC_Horas_Extra() {
        return C_Horas_Extra;
    }

    /**
     * @param C_Horas_Extra the C_Horas_Extra to set
     */
    public void setC_Horas_Extra(int C_Horas_Extra) {
        this.C_Horas_Extra = C_Horas_Extra;
    }

    /**
     * @return the C_Estado_Pago
     */
    public int getC_Estado_Pago() {
        return C_Estado_Pago;
    }

    /**
     * @param C_Estado_Pago the C_Estado_Pago to set
     */
    public void setC_Estado_Pago(int C_Estado_Pago) {
        this.C_Estado_Pago = C_Estado_Pago;
    }

    /**
     * @return the F_Emision
     */
    public Date getF_Emision() {
        return F_Emision;
    }

    /**
     * @param F_Emision the F_Emision to set
     */
    public void setF_Emision(Date F_Emision) {
        this.F_Emision = F_Emision;
    }

    /**
     * @return the F_Pago
     */
    public Date getF_Pago() {
        return F_Pago;
    }

    /**
     * @param F_Pago the F_Pago to set
     */
    public void setF_Pago(Date F_Pago) {
        this.F_Pago = F_Pago;
    }

    /**
     * @return the M_Pago
     */
    public double getM_Pago() {
        return M_Pago;
    }

    /**
     * @param M_Pago the M_Pago to set
     */
    public void setM_Pago(double M_Pago) {
        this.M_Pago = M_Pago;
    }

    /**
     * @return the M_Pago_CCSS
     */
    public double getM_Pago_CCSS() {
        return M_Pago_CCSS;
    }

    /**
     * @param M_Pago_CCSS the M_Pago_CCSS to set
     */
    public void setM_Pago_CCSS(double M_Pago_CCSS) {
        this.M_Pago_CCSS = M_Pago_CCSS;
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

    @Override
    public String toString() {
        return "Pagos_Empleados{" + "C_Pago_Empleado=" + C_Pago_Empleado + ", C_Empleado=" + C_Empleado + ", C_Horas_Extra=" + C_Horas_Extra + ", C_Estado_Pago=" + C_Estado_Pago + ", F_Emision=" + F_Emision + ", F_Pago=" + F_Pago + ", M_Pago=" + M_Pago + ", M_Pago_CCSS=" + M_Pago_CCSS + ", C_Bonificacion=" + C_Bonificacion + '}';
    }
    
    
    
}
