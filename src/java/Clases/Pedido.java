/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.sql.Time;

/**
 *
 * @author yorda
 */
public class Pedido {
    private int cPedido;
    private int cMesa;
    private int cEmpleado;
    private int cExpress;
    private int cCliente;
    private int cSucursal;
    private Time horaSolucitud;
    private Time horaEntrega;

    public Pedido() {
    }

    public Pedido(int cPedido, int cMesa, int cEmpleado, int cExpress, int cCliente, int cSucursal, Time horaSolucitud, Time horaEntrega) {
        this.cPedido = cPedido;
        this.cMesa = cMesa;
        this.cEmpleado = cEmpleado;
        this.cExpress = cExpress;
        this.cCliente = cCliente;
        this.cSucursal = cSucursal;
        this.horaSolucitud = horaSolucitud;
        this.horaEntrega = horaEntrega;
    }

    /**
     * @return the cPedido
     */
    public int getcPedido() {
        return cPedido;
    }

    /**
     * @param cPedido the cPedido to set
     */
    public void setcPedido(int cPedido) {
        this.cPedido = cPedido;
    }

    /**
     * @return the cMesa
     */
    public int getcMesa() {
        return cMesa;
    }

    /**
     * @param cMesa the cMesa to set
     */
    public void setcMesa(int cMesa) {
        this.cMesa = cMesa;
    }

    /**
     * @return the cEmpleado
     */
    public int getcEmpleado() {
        return cEmpleado;
    }

    /**
     * @param cEmpleado the cEmpleado to set
     */
    public void setcEmpleado(int cEmpleado) {
        this.cEmpleado = cEmpleado;
    }

    /**
     * @return the cExpress
     */
    public int getcExpress() {
        return cExpress;
    }

    /**
     * @param cExpress the cExpress to set
     */
    public void setcExpress(int cExpress) {
        this.cExpress = cExpress;
    }

    /**
     * @return the cCliente
     */
    public int getcCliente() {
        return cCliente;
    }

    /**
     * @param cCliente the cCliente to set
     */
    public void setcCliente(int cCliente) {
        this.cCliente = cCliente;
    }

    /**
     * @return the cSucursal
     */
    public int getcSucursal() {
        return cSucursal;
    }

    /**
     * @param cSucursal the cSucursal to set
     */
    public void setcSucursal(int cSucursal) {
        this.cSucursal = cSucursal;
    }

    /**
     * @return the horaSolucitud
     */
    public Time getHoraSolucitud() {
        return horaSolucitud;
    }

    /**
     * @param horaSolucitud the horaSolucitud to set
     */
    public void setHoraSolucitud(Time horaSolucitud) {
        this.horaSolucitud = horaSolucitud;
    }

    /**
     * @return the horaEntrega
     */
    public Time getHoraEntrega() {
        return horaEntrega;
    }

    /**
     * @param horaEntrega the horaEntrega to set
     */
    public void setHoraEntrega(Time horaEntrega) {
        this.horaEntrega = horaEntrega;
    }

    @Override
    public String toString() {
        return "Pedido{" + "cPedido=" + cPedido + ", cMesa=" + cMesa + ", cEmpleado=" + cEmpleado + ", cExpress=" + cExpress + ", cCliente=" + cCliente + ", cSucursal=" + cSucursal + ", horaSolucitud=" + horaSolucitud + ", horaEntrega=" + horaEntrega + '}';
    }
    
    
}
