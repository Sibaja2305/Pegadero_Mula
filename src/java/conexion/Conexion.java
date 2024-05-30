/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import Clases.Caja;
import Clases.Canton;
import Clases.DireccionFisica;
import Clases.Distrito;
import Clases.Empleado;
import Clases.HorasExtras;
import Clases.PagosServicios;
import Clases.Provincia;
import Clases.RolEmpleado;
import Clases.Servicios;
import Clases.Sucursal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author Hp EliteBook
 */
public class Conexion {

    public static Connection getConexion() {
        String conexionUrl = "jdbc:sqlserver://localhost:1433;"
                + "database=Pegadero_Mula;user=sibaja;"
                + "password=root2;loginTimeout=30;"
                + "trustServerCertificate=true";
        try {
            // Registrar el driver explícitamente
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(conexionUrl);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: Driver no encontrado");
            ex.printStackTrace();
            return null;
        } catch (SQLException ex) {
            System.out.println("Error: No se pudo establecer la conexión");
            ex.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Cliente> busqueda(String criterioBusqueda) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conexion = Conexion.getConexion(); // Obtener la conexión

        if (conexion != null) {
            ArrayList<Cliente> clientes = new ArrayList<>();
            String procedimiento = "{call SP_OBTENER_CLIENTES_BUSQUEDA(?)}";

            try (CallableStatement llamada = conexion.prepareCall(procedimiento)) {
                llamada.setString(1, criterioBusqueda); // Establecer el parámetro

                ResultSet resultado = llamada.executeQuery(); // Ejecutar el procedimiento almacenado

                while (resultado.next()) {

                    String nombre = resultado.getString("D_Nombre");
                    String primerApellido = resultado.getString("D_Primer_Apellido");
                    String segundoApellido = resultado.getString("D_Segundo_Apellido");
                    Cliente cliente = new Cliente(nombre, primerApellido, segundoApellido);
                    clientes.add(cliente);
                }
            }

            return clientes; // Devolver el ArrayList de clientes
        }

        return null; // En caso de conexión nula
    }

    public boolean insertarProvincia(int cProvincia, String dProvincia) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection con = getConexion();
                CallableStatement datos = con.prepareCall("{call SP_Insertar_Provincia(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            datos.setInt(1, cProvincia);
            datos.setString(2, dProvincia);

            // Ejecutar el procedimiento almacenado
            datos.execute();

            System.out.println("Provincia insertada correctamente.");
            con.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Provincia> getProvincias() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<Provincia> provincias = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement cstmt = con.prepareCall("{call SP_Seleccionar_Provincias}");
                ResultSet rs = cstmt.executeQuery()) {

            while (rs.next()) {
                int cProvincia = rs.getInt("C_Provincia");
                String dProvincia = rs.getString("D_Provincia");

                Provincia provincia = new Provincia(cProvincia, dProvincia);
                provincias.add(provincia);
            }
        } catch (SQLException ex) {
            System.out.println("Error al obtener provincias: " + ex.getMessage());
            throw ex;
        }
        return provincias;
    }

    public boolean eliminarProvincia(int cProvincia) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Provincia(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cProvincia);

            // Ejecutar el procedimiento almacenado
            stmt.execute();

            System.out.println("Provincia eliminada correctamente.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarProvincia(int cProvincia, String dProvincia) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Provincia(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cProvincia);
            stmt.setString(2, dProvincia);

            // Ejecutar el procedimiento almacenado
            stmt.execute();

            System.out.println("Provincia actualizada correctamente.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertarCanton(int cProvincia, String dCanton) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Canton(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cProvincia);
            stmt.setString(2, dCanton);

            // Ejecutar el procedimiento almacenado
            stmt.execute();

            System.out.println("Cantón insertado correctamente.");
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar el cantón: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Canton> obtenerCantones() {
        ArrayList<Canton> cantones = new ArrayList<>();

        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Cantones}");
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cCanton = rs.getInt("C_Canton");
                int cProvincia = rs.getInt("C_Provincia");
                String dCanton = rs.getString("D_Canton");

                Canton canton = new Canton(cCanton, cProvincia, dCanton);
                cantones.add(canton);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los cantones: " + e.getMessage());
        }

        return cantones;
    }

    public boolean eliminarCanton(int cCanton) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Canton(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cCanton);

            // Ejecutar el procedimiento almacenado
            stmt.execute();

            System.out.println("Canton eliminado correctamente.");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean actualizarCanton(int cCanton, int cProvincia, String dCanton) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Update_Canton(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cCanton);
            stmt.setInt(2, cProvincia);
            stmt.setString(3, dCanton);

            // Ejecutar el procedimiento almacenado
            stmt.executeUpdate();
            return true; // Éxito en la actualización
        } catch (SQLException e) {
            System.out.println("Error al actualizar el cantón: " + e.getMessage());
            return false; // Falla en la actualización
        }
    }

    public boolean insertarDistrito(int cCanton, String dDistrito) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Distrito(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cCanton);
            stmt.setString(2, dDistrito);

            // Ejecutar el procedimiento almacenado
            stmt.executeUpdate();
            return true; // Éxito en la inserción
        } catch (SQLException e) {
            System.out.println("Error al insertar el distrito: " + e.getMessage());
            return false; // Falla en la inserción
        }
    }

    public ArrayList<Distrito> getDistritos() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<Distrito> distritos = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement cstmt = con.prepareCall("{call SP_Seleccionar_Distrito}");
                ResultSet rs = cstmt.executeQuery()) {

            while (rs.next()) {
                int cDistrito = rs.getInt("C_Distrito");
                int cCanton = rs.getInt("C_Canton");
                String dDistrito = rs.getString("D_Distrito");

                Distrito distrito = new Distrito(cDistrito, cCanton, dDistrito);
                distritos.add(distrito);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
        return distritos;
    }

    public boolean eliminarDistrito(int cDistrito) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Distrito(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cDistrito);

            // Ejecutar el procedimiento almacenado
            stmt.executeUpdate();
            System.out.println("Distrito eliminado correctamente.");
            return true; // Éxito en la eliminación
        } catch (SQLException e) {
            System.out.println("Error al eliminar el distrito: " + e.getMessage());
            return false; // Falla en la eliminación
        }
    }

    public boolean actualizarDistrito(int cDistrito, int cCanton, String dDistrito) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Distrito(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cDistrito);
            stmt.setInt(2, cCanton);
            stmt.setString(3, dDistrito);

            // Ejecutar el procedimiento almacenado
            stmt.executeUpdate();
            System.out.println("Distrito actualizado correctamente.");
            return true; // Éxito en la actualización
        } catch (SQLException e) {
            System.out.println("Error al actualizar el distrito: " + e.getMessage());
            return false; // Falla en la actualización
        }
    }

    public ArrayList<DireccionFisica> obtenerDireccionesFisicas() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        ArrayList<DireccionFisica> direcciones = new ArrayList<>();

        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Direcciones_Fisicas}");
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cDireccionFisica = rs.getInt("C_Direccion_Fisica");
                int cDistrito = rs.getInt("C_Distrito");
                String dDireccionFisica = rs.getString("D_Direccion_Fisica");

                DireccionFisica direccion = new DireccionFisica(cDireccionFisica, cDistrito, dDireccionFisica);
                direcciones.add(direccion);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las direcciones físicas: " + e.getMessage());
        }

        return direcciones;
    }

    public boolean insertarDireccionFisica(int cDistrito, String dDireccionFisica) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Direccion_Fisica(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cDistrito);
            stmt.setString(2, dDireccionFisica);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar dirección física: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarDireccionFisica(int cDireccionFisica) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Direccion_Fisica(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cDireccionFisica);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar dirección física: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarDireccionFisica(int cDireccionFisica, int cDistrito, String dDireccionFisica) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Direccion_Fisica(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cDireccionFisica);
            stmt.setInt(2, cDistrito);
            stmt.setString(3, dDireccionFisica);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar dirección física: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Sucursal> obtenerSucursales() {
        ArrayList<Sucursal> sucursales = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Sucursales()}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar las sucursales a la lista
            while (rs.next()) {
                int cSucursal = rs.getInt("C_Sucursal");
                String dSucursal = rs.getString("D_Sucursal");
                String nTelefono = rs.getString("N_Telefono");
                String dCorreoElectronico = rs.getString("D_Correo_Electronico");
                int cDireccionFisica = rs.getInt("C_Direccion_Fisica");

                Sucursal sucursal = new Sucursal(cSucursal, dSucursal, nTelefono, dCorreoElectronico, cDireccionFisica);
                sucursales.add(sucursal);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las sucursales: " + e.getMessage());
        }
        return sucursales;
    }

    public boolean insertarSucursal(String dSucursal, String nTelefono, String dCorreoElectronico, int cDireccionFisica) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Sucursales(?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setString(1, dSucursal);
            stmt.setString(2, nTelefono);
            stmt.setString(3, dCorreoElectronico);
            stmt.setInt(4, cDireccionFisica);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar sucursal: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarSucursal(int cSucursal) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Sucursales(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cSucursal);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar dirección física: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarSucursal(int cSucursal, String dSucursal, String nTelefono, String dCorreoElectronico, int cDireccionFisica) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Sucursales(?, ?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cSucursal);
            stmt.setString(2, dSucursal);
            stmt.setString(3, nTelefono);
            stmt.setString(4, dCorreoElectronico);
            stmt.setInt(5, cDireccionFisica);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar sucursal: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Servicios> getServicios() throws SQLException {
        ArrayList<Servicios> servicios = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement cstmt = con.prepareCall("{call SP_Seleccionar_Servicios}");
                ResultSet rs = cstmt.executeQuery()) {

            while (rs.next()) {
                int cServicio = rs.getInt("C_Servicio");
                String Servicio = rs.getString("D_Servicio");
                Date fVencimiento = rs.getDate("F_Vencimiento");

                Servicios servicio = new Servicios(cServicio, Servicio, fVencimiento);
                servicios.add(servicio);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
        return servicios;
    }

    public boolean insertarServicio(String dServicio, Date fVencimiento) {
        try (Connection con = getConexion();
                CallableStatement cstmt = con.prepareCall("{call SP_Insertar_Servicios(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            cstmt.setString(1, dServicio);
            cstmt.setDate(2, new java.sql.Date(fVencimiento.getTime()));

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            System.out.println("Servicio insertado correctamente.");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean eliminarServicio(int cServicio) {
        try (Connection con = Conexion.getConexion();
                CallableStatement cstmt = con.prepareCall("{call SP_Eliminar_Servicios(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            cstmt.setInt(1, cServicio);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            System.out.println("Servicio eliminado correctamente.");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el servicio: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean actualizarServicio(int cServicio, String dServicio, Date fVencimiento) {

        try (Connection con = Conexion.getConexion();
                CallableStatement cstmt = con.prepareCall("{call SP_Actualizar_Servicios(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            cstmt.setInt(1, cServicio);
            cstmt.setString(2, dServicio);
            cstmt.setDate(3, fVencimiento);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            System.out.println("Servicio actualizado correctamente.");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al actualizar el servicio: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<PagosServicios> obtenerPagosServicios() throws SQLException {
        ArrayList<PagosServicios> pagosServicios = new ArrayList<>();
        String procedimientoAlmacenado = "{call SP_Seleccionar_Pagos_Servicios}";

        try (Connection conn = Conexion.getConexion();
                CallableStatement cs = conn.prepareCall(procedimientoAlmacenado);
                ResultSet rs = cs.executeQuery()) {

            while (rs.next()) {
                int cPagoServicio = rs.getInt("C_Pago_Servicio");
                int cServicio = rs.getInt("C_Servicio");
                int cSucursal = rs.getInt("C_Sucursal");
                double mPago = rs.getDouble("M_Pago");
                java.sql.Timestamp fPago = rs.getTimestamp("F_Pago");

                PagosServicios pagoServicio = new PagosServicios(cPagoServicio, cServicio, cSucursal, mPago, fPago);
                pagosServicios.add(pagoServicio);
            }
        }

        return pagosServicios;
    }

    public boolean insertarPagoServicio(int cServicio, int cSucursal, double mPago, Timestamp fPago) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Pagos_Servicios(?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cServicio);
            stmt.setInt(2, cSucursal);
            stmt.setDouble(3, mPago);
            stmt.setTimestamp(4, fPago);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar pago de servicio: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarPagoServicio(int cPagoServicio) {
        try (Connection con = Conexion.getConexion();
                CallableStatement cstmt = con.prepareCall("{call SP_Eliminar_Pagos_Servicios(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            cstmt.setInt(1, cPagoServicio);

            // Ejecutar el procedimiento almacenado
            cstmt.execute();

            System.out.println("Servicio eliminado correctamente.");
            return true;
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el servicio: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public boolean actualizarPagoServicio(int cPagoServicio, int cServicio, int cSucursal, double mPago) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Pagos_Servicios(?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cPagoServicio);
            stmt.setInt(2, cServicio);
            stmt.setInt(3, cSucursal);
            stmt.setDouble(4, mPago);

            // Ejecutar el procedimiento almacenado
            stmt.executeUpdate();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar el pago de servicio: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Caja> getCaja() {
        ArrayList<Caja> listaCajas = new ArrayList<>();

        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Caja}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Procesar los resultados del ResultSet
            while (rs.next()) {
                int cCaja = rs.getInt("C_Caja");
                int cSucursal = rs.getInt("C_Sucursal");
                double mInicio = rs.getDouble("M_Inicio");
                double mFinal = rs.getDouble("M_Final");
                Time fApertura = rs.getTime("F_Apertura");
                Time fCierre = rs.getTime("F_Cierre");
                Date fFechaCaja = rs.getDate("F_Fecha_Caja");

                // Crear un objeto Caja y añadirlo a la lista
                Caja caja = new Caja(cCaja, cSucursal, mInicio, mFinal, fApertura, fCierre, fFechaCaja);
                listaCajas.add(caja);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar caja: " + e.getMessage());
        }

        return listaCajas;
    }

    public boolean insertarCaja(int cSucursal, double mInicio, double mFinal, Time fApertura, Time fCierre, Date fFechaCaja) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Caja(?, ?, ?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cSucursal);
            stmt.setDouble(2, (mInicio));
            stmt.setDouble(3, (mFinal));
            stmt.setTime(4, fApertura);
            stmt.setTime(5, fCierre);
            stmt.setDate(6, fFechaCaja);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar caja: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarCaja(int cCaja) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Caja(?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cCaja);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar caja: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarCaja(int cCaja, int cSucursal, double mInicio, double mFinal, Time fApertura, Time fCierre, Date fFechaCaja) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Caja(?, ?, ?, ?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cCaja);
            stmt.setInt(2, cSucursal);
            stmt.setDouble(3, mInicio);
            stmt.setDouble(4, mFinal);
            stmt.setTime(5, fApertura);
            stmt.setTime(6, fCierre);
            stmt.setDate(7, fFechaCaja);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar caja: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<RolEmpleado> getRolesEmpleado() {
        ArrayList<RolEmpleado> roles = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Roles_Empleado}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Procesar los resultados
            while (rs.next()) {
                int cRolEmpleado = rs.getInt("C_Rol_Empleado");
                String dRolEmpleado = rs.getString("D_Rol_Empleado");
                roles.add(new RolEmpleado(cRolEmpleado, dRolEmpleado));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener roles de empleado: " + e.getMessage());
        }
        return roles; // Devolver la lista de roles
    }

    public boolean insertarRolEmpleado(String dRolEmpleado) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Roles_Empleado(?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setString(1, dRolEmpleado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar rol de empleado: " + e.getMessage());
            return false; // Indicar que la inserción falló

        }

    }

    public boolean eliminarRolEmpleado(int cRolEmpleado) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Roles_Empleado(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cRolEmpleado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar rol de empleado: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }

    }

    public boolean actualizarRolEmpleado(int cRolEmpleado, String dRolEmpleado) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Roles_Empleado(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cRolEmpleado);
            stmt.setString(2, dRolEmpleado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar rol de empleado: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<HorasExtras> getHorasExtra() {
        ArrayList<HorasExtras> horasExtra = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Horas_Extra}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Procesar los resultados
            while (rs.next()) {
                int cHorasExtra = rs.getInt("C_Horas_Extra");
                Date fFecha = rs.getDate("F_Fecha");
                int qHoras = rs.getInt("Q_Horas");
                horasExtra.add(new HorasExtras(cHorasExtra, fFecha, qHoras));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener horas extra: " + e.getMessage());
        }
        return horasExtra; // Devolver la lista de horas extra
    }

    public boolean insertarHorasExtra(Date fFecha, int qHoras) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Horas_Extra(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setDate(1, new java.sql.Date(fFecha.getTime()));
            stmt.setInt(2, qHoras);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar horas extra: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarHorasExtra(int cHorasExtra) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Horas_Extra(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cHorasExtra);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar horas extra: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarHorasExtra(int cHorasExtra, Date fFecha, int qHoras) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Horas_Extra(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cHorasExtra);
            stmt.setDate(2, new java.sql.Date(fFecha.getTime()));
            stmt.setInt(3, qHoras);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar horas extra: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Empleado> seleccionarEmpleados() {
        ArrayList<Empleado> empleados = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Empleado}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Procesar los resultados
            while (rs.next()) {
                int cEmpleado = rs.getInt("C_Empleado");
                int cRolEmpleado = rs.getInt("C_Rol_Empleado");
                int cHorasExtra = rs.getInt("C_Horas_Extra");
                int cSucursal = rs.getInt("C_Sucursal");
                String dIdentificacion = rs.getString("D_Identificacion");
                String dNombre = rs.getString("D_Nombre");
                String dPrimerApellido = rs.getString("D_Primer_Apellido");
                String dSegundoApellido = rs.getString("D_Segundo_Apellido");
                double mSalario = rs.getDouble("M_Salario");

                // Crear objeto Empleado y agregarlo a la lista
                Empleado empleado = new Empleado(cEmpleado, cRolEmpleado, cHorasExtra, cSucursal,
                        dIdentificacion, dNombre, dPrimerApellido, dSegundoApellido, mSalario);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar empleados: " + e.getMessage());
        }
        return empleados; // Devolver la lista de empleados
    }

    public boolean insertarEmpleado(int cRolEmpleado, int cHorasExtra, int cSucursal, String dIdentificacion, String dNombre,
            String dPrimerApellido, String dSegundoApellido, double mSalario) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Empleado(?, ?, ?, ?, ?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cRolEmpleado);
            stmt.setInt(2, cHorasExtra);
            stmt.setInt(3, cSucursal);
            stmt.setString(4, dIdentificacion);
            stmt.setString(5, dNombre);
            stmt.setString(6, dPrimerApellido);
            stmt.setString(7, dSegundoApellido);
            stmt.setDouble(8, mSalario);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar empleado: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarEmpleado(int cEmpleado) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Empleado(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cEmpleado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarEmpleado(int cEmpleado, int cRolEmpleado, int cHorasExtra, int cSucursal,
            String dIdentificacion, String dNombre,
            String dPrimerApellido, String dSegundoApellido,
            double mSalario) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Empleado(?, ?, ?, ?, ?, ?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cEmpleado);
            stmt.setInt(2, cRolEmpleado);

            stmt.setInt(3, cHorasExtra);

            stmt.setInt(4, cSucursal);
            stmt.setString(5, dIdentificacion);
            stmt.setString(6, dNombre);
            stmt.setString(7, dPrimerApellido);
            stmt.setString(8, dSegundoApellido);
            stmt.setDouble(9, mSalario);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }
}
