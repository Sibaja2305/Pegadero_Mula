/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

/**
 *
 * @author Hp EliteBook
 */
public class Cliente {
    private int id;
    private String nombre;
    private String primerApellido;
    private String SegundoApellido;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String primerApellido, String SegundoApellido) {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.SegundoApellido = SegundoApellido;
    }

    public Cliente(String nombre, String primerApellido, String SegundoApellido) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.SegundoApellido = SegundoApellido;
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the primerApellido
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * @param primerApellido the primerApellido to set
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * @return the SegundoApellido
     */
    public String getSegundoApellido() {
        return SegundoApellido;
    }

    /**
     * @param SegundoApellido the SegundoApellido to set
     */
    public void setSegundoApellido(String SegundoApellido) {
        this.SegundoApellido = SegundoApellido;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", SegundoApellido=" + SegundoApellido + '}';
    }
    
}
