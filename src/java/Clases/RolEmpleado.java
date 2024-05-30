/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Hp EliteBook
 */
public class RolEmpleado {
  private int codigoRol;
private String rol;

    public RolEmpleado() {
    }

    public RolEmpleado(int codigoRol, String rol) {
        this.codigoRol = codigoRol;
        this.rol = rol;
    }

    /**
     * @return the codigoRol
     */
    public int getCodigoRol() {
        return codigoRol;
    }

    /**
     * @param codigoRol the codigoRol to set
     */
    public void setCodigoRol(int codigoRol) {
        this.codigoRol = codigoRol;
    }

    /**
     * @return the rol
     */
    public String getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "RolEmpleado{" + "codigoRol=" + codigoRol + ", rol=" + rol + '}';
    }

}
