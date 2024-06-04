/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import Clases.Bonificacion;
import Clases.Caja;
import Clases.Canton;
import Clases.Cliente;
import Clases.ClienteBusqueda;
import Clases.ClientesSucursales;
import Clases.Combo;
import Clases.ComboProducto;
import Clases.DetallePedido;
import Clases.DireccionFisica;
import Clases.Distrito;
import Clases.Empleado;
import Clases.EstadoPago;
import Clases.Express;
import Clases.Factura;
import Clases.HorasExtras;
import Clases.Impuesto;
import Clases.Ingredientes;
import Clases.Mesa;
import Clases.MetodoPago;
import Clases.PagoEmpleado;
import Clases.PagoProveedor;
import Clases.PagosServicios;
import Clases.Pedido;
import Clases.Producto;
import Clases.ProductoIngrediente;
import Clases.Proveedor;
import Clases.Provincia;
import Clases.RolEmpleado;
import Clases.Servicios;
import Clases.Sucursal;
import Clases.TipoProducto;
import Clases.UnidadMedida;
import Clases.Vacaciones;
import Clases.VerFactura;

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
                + "database=Pegadero_Mula;user=admin;"
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

    public static ArrayList<ClienteBusqueda> busqueda(String criterioBusqueda) throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conexion = Conexion.getConexion(); // Obtener la conexión

        if (conexion != null) {
            ArrayList<ClienteBusqueda> clientes = new ArrayList<>();
            String procedimiento = "{call SP_OBTENER_CLIENTES_BUSQUEDA(?)}";

            try (CallableStatement llamada = conexion.prepareCall(procedimiento)) {
                llamada.setString(1, criterioBusqueda); // Establecer el parámetro

                ResultSet resultado = llamada.executeQuery(); // Ejecutar el procedimiento almacenado

                while (resultado.next()) {

                    String nombre = resultado.getString("D_Nombre");
                    String primerApellido = resultado.getString("D_Primer_Apellido");
                    String segundoApellido = resultado.getString("D_Segundo_Apellido");
                    ClienteBusqueda cliente = new ClienteBusqueda(nombre, primerApellido, segundoApellido);
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

    public ArrayList<Bonificacion> seleccionarBonificaciones() {
        ArrayList<Bonificacion> bonificaciones = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Bonificaciones}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cBonificacion = rs.getInt("C_Bonificacion");
                Date fBonificacion = rs.getDate("F_Bonificacion");
                double mBonificacion = rs.getDouble("M_Bonificacion");
                String dMotivo = rs.getString("D_Motivo");
                int cEmpleado = rs.getInt("C_Empleado");

                Bonificacion bonificacion = new Bonificacion(cBonificacion, fBonificacion, mBonificacion, dMotivo, cEmpleado);
                bonificaciones.add(bonificacion);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar bonificaciones: " + e.getMessage());
        }

        return bonificaciones;
    }

    public boolean insertarBonificacion(Date fBonificacion, double mBonificacion, String dMotivo, int cEmpleado) {
        String procedimiento = "{call SP_Insertar_Bonificaciones(?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setDate(1, (fBonificacion));
            stmt.setDouble(2, mBonificacion);
            stmt.setString(3, dMotivo);
            stmt.setInt(4, cEmpleado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar bonificación: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarBonificacion(int cBonificacion) {
        String procedimiento = "{call SP_Eliminar_Bonificaciones(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cBonificacion);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar bonificación: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarBonificacion(int cBonificacion, Date fBonificacion, double mBonificacion, String dMotivo, int cEmpleado) {
        String procedimiento = "{call SP_Actualizar_Bonificaciones(?, ?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cBonificacion);
            stmt.setDate(2, (fBonificacion)); // Convertir java.util.Date a java.sql.Date
            stmt.setDouble(3, mBonificacion); // Convertir double a BigDecimal
            stmt.setString(4, dMotivo);
            stmt.setInt(5, cEmpleado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar bonificación: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Vacaciones> seleccionarVacaciones() {
        ArrayList<Vacaciones> vacaciones = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Vacaciones}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cVacaciones = rs.getInt("C_Vacaciones");
                int cEmpleado = rs.getInt("C_Empleado");
                Date fInicio = rs.getDate("F_Inicio");
                Date fFinalizacion = rs.getDate("F_Finalizacion");

                Vacaciones vacacion = new Vacaciones(cVacaciones, cEmpleado, fInicio, fFinalizacion);
                vacaciones.add(vacacion);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar vacaciones: " + e.getMessage());
        }

        return vacaciones;
    }

    public boolean insertarVacaciones(int cEmpleado, Date fInicio, Date fFinalizacion) {
        String procedimiento = "{call SP_Insertar_Vacaciones(?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cEmpleado);
            stmt.setDate(2, fInicio);
            stmt.setDate(3, fFinalizacion);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar vacaciones: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarVacaciones(int cVacaciones) {
        String procedimiento = "{call SP_Eliminar_Vacaciones(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cVacaciones);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar vacaciones: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarVacaciones(int cVacaciones, int cEmpleado, java.util.Date fInicio, java.util.Date fFinalizacion) {
        String procedimiento = "{call SP_Actualizar_Vacaciones(?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cVacaciones);
            stmt.setInt(2, cEmpleado);
            stmt.setDate(3, new Date(fInicio.getTime())); // Convertir java.util.Date a java.sql.Date
            stmt.setDate(4, new Date(fFinalizacion.getTime())); // Convertir java.util.Date a java.sql.Date

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar vacaciones: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<EstadoPago> seleccionarEstadoPago() {
        ArrayList<EstadoPago> estadosPago = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Estado_Pago}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cEstadoPago = rs.getInt("C_Estado_Pago");
                String dEstado = rs.getString("D_Estado");

                EstadoPago estadoPago = new EstadoPago(cEstadoPago, dEstado);
                estadosPago.add(estadoPago);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar estados de pago: " + e.getMessage());
        }

        return estadosPago;
    }

    public boolean insertarEstadoPago(String dEstado) {
        String procedimiento = "{call SP_Insertar_Estado_Pago(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setString(1, dEstado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar estado de pago: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarEstadoPago(int cEstadoPago) {
        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Estado_Pago(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cEstadoPago);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar estado de pago: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarEstadoPago(int cEstadoPago, String dEstado) {
        String procedimiento = "{call SP_Actualizar_Estado_Pago(?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cEstadoPago);
            stmt.setString(2, dEstado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar estado de pago: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<PagoEmpleado> seleccionarPagosEmpleados() {
        ArrayList<PagoEmpleado> pagosEmpleados = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Pagos_Empleados}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cPagoEmpleado = rs.getInt("C_Pago_Empleado");
                int cEmpleado = rs.getInt("C_Empleado");
                int cHorasExtra = rs.getInt("C_Horas_Extra");
                int cEstadoPago = rs.getInt("C_Estado_Pago");
                Date fEmision = rs.getDate("F_Emision");
                Date fPago = rs.getDate("F_Pago");
                double mPago = rs.getDouble("M_Pago");
                double mPagoCCSS = rs.getDouble("M_Pago_CCSS");
                int cBonificacion = rs.getInt("C_Bonificacion");

                PagoEmpleado pagoEmpleado = new PagoEmpleado(cPagoEmpleado, cEmpleado, cHorasExtra, cEstadoPago, fEmision, fPago, mPago, mPagoCCSS, cBonificacion);
                pagosEmpleados.add(pagoEmpleado);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar pagos de empleados: " + e.getMessage());
        }

        return pagosEmpleados;
    }

    public boolean insertarPagoEmpleado(int cEmpleado, int cHorasExtra, int cEstadoPago, Date fEmision, Date fPago, double mPago, double mPagoCCSS, int cBonificacion) {
        String procedimiento = "{call SP_Insertar_Pagos_Empleados(?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cEmpleado);
            stmt.setInt(2, cHorasExtra);
            stmt.setInt(3, cEstadoPago);
            stmt.setDate(4, fEmision);
            stmt.setDate(5, fPago);
            stmt.setDouble(6, mPago);
            stmt.setDouble(7, mPagoCCSS);
            stmt.setInt(8, cBonificacion);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar pago de empleado: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarPagoEmpleado(int cPagoEmpleado) {
        String procedimiento = "{call SP_Eliminar_Pagos_Empleados(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cPagoEmpleado);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar pago de empleado: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarPagoEmpleado(int cPagoEmpleado, int cEmpleado, int cHorasExtra, int cEstadoPago,
            Date fEmision, Date fPago, double mPago, double mPagoCCSS, int cBonificacion) {
        String procedimiento = "{call SP_Actualizar_Pagos_Empleados(?, ?, ?, ?, ?, ?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cPagoEmpleado);
            stmt.setInt(2, cEmpleado);
            stmt.setInt(3, cHorasExtra);
            stmt.setInt(4, cEstadoPago);
            stmt.setDate(5, fEmision);
            stmt.setDate(6, fPago);
            stmt.setDouble(7, mPago);
            stmt.setDouble(8, mPagoCCSS);
            stmt.setInt(9, cBonificacion);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar pago de empleado: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Cliente> obtenerClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Cliente}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar los clientes a la lista
            while (rs.next()) {
                int cCliente = rs.getInt("C_Cliente");
                int cDireccionFisica = rs.getInt("C_Direccion_Fisica");
                String cCedula = rs.getString("C_Cedula");
                String nNumeroTelefono = rs.getString("N_Numero_Telefono");

                Cliente cliente = new Cliente(cCliente, cDireccionFisica, cCedula, nNumeroTelefono);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes: " + e.getMessage());
        }
        return clientes;
    }

    public boolean insertarCliente(int cDireccionFisica, String cCedula, String nNumeroTelefono) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Cliente(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cDireccionFisica);
            stmt.setString(2, cCedula);
            stmt.setString(3, nNumeroTelefono);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarCliente(int cCliente) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Cliente(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cCliente);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarCliente(int cCliente, int cDireccionFisica, String cCedula, String nNumeroTelefono) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Cliente(?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cCliente);
            stmt.setInt(2, cDireccionFisica);
            stmt.setString(3, cCedula);
            stmt.setString(4, nNumeroTelefono);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Proveedor> seleccionarProveedores() {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Proveedores}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cProveedor = rs.getInt("C_Proveedor");
                int cSucursal = rs.getInt("C_Sucursal");
                String dProveedor = rs.getString("D_Proveedor");

                Proveedor proveedor = new Proveedor(cProveedor, cSucursal, dProveedor);
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar proveedores: " + e.getMessage());
        }

        return proveedores;
    }

    public boolean insertarProveedor(int cSucursal, String dProveedor) {
        String procedimiento = "{call SP_Insertar_Proveedores(?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cSucursal);
            stmt.setString(2, dProveedor);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar proveedor: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarProveedor(int cProveedor) {
        String procedimiento = "{call SP_Eliminar_Proveedores(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cProveedor);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar proveedor: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarProveedor(int cProveedor, int cSucursal, String dProveedor) {
        String procedimiento = "{call SP_Actualizar_Proveedores(?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cProveedor);
            stmt.setInt(2, cSucursal);
            stmt.setString(3, dProveedor);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar proveedor: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<UnidadMedida> seleccionarUnidadesMedida() {
        ArrayList<UnidadMedida> unidadesMedida = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Unidades_Medida}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cUnidadMedida = rs.getInt("C_Unidad_Medida");
                String dUnidadMedida = rs.getString("D_Unidad_Medida");
                double qValor = rs.getDouble("Q_Valor");

                UnidadMedida unidad = new UnidadMedida(cUnidadMedida, dUnidadMedida, qValor);
                unidadesMedida.add(unidad);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar unidades de medida: " + e.getMessage());
        }

        return unidadesMedida;
    }

    public boolean insertarUnidadMedida(String dUnidadMedida, double qValor) {
        String procedimiento = "{call SP_Insertar_Unidades_Medida(?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setString(1, dUnidadMedida);
            stmt.setDouble(2, qValor);

            // Ejecutar el procedimiento almacenado
            stmt.executeUpdate();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar unidad de medida: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarUnidadMedida(int cUnidadMedida) {
        String procedimiento = "{call SP_Eliminar_Unidades_Medida(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cUnidadMedida);

            // Ejecutar el procedimiento almacenado
            stmt.executeUpdate();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar unidad de medida: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarUnidadMedida(int cUnidadMedida, String dUnidadMedida, double qValor) {
        String procedimiento = "{call SP_Actualizar_Unidades_Medida(?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cUnidadMedida);
            stmt.setString(2, dUnidadMedida);
            stmt.setDouble(3, qValor);

            // Ejecutar el procedimiento almacenado
            stmt.executeUpdate();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar unidad de medida: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Ingredientes> seleccionarIngredientes() {
        ArrayList<Ingredientes> ingredientes = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Ingredientes}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cIngrediente = rs.getInt("C_Ingrediente");
                int cSucursal = rs.getInt("C_Sucursal");
                int cProveedor = rs.getInt("C_Proveedor");
                String dIngrediente = rs.getString("D_Ingrediente");
                double qActual = rs.getDouble("Q_Actual");
                int cUnidadMedida = rs.getInt("C_Unidad_Medida");

                Ingredientes ingrediente = new Ingredientes(cIngrediente, cSucursal, cProveedor, dIngrediente, qActual, cUnidadMedida);
                ingredientes.add(ingrediente);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar ingredientes: " + e.getMessage());
        }

        return ingredientes;
    }

    public boolean insertarIngrediente(int cSucursal, int cProveedor, String dIngrediente, double qActual, int cUnidadMedida) {
        String procedimiento = "{call SP_Insertar_Ingredientes(?, ?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cSucursal);
            stmt.setInt(2, cProveedor);
            stmt.setString(3, dIngrediente);
            stmt.setDouble(4, qActual);
            stmt.setInt(5, cUnidadMedida);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar ingrediente: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarIngrediente(int cIngrediente) {
        String procedimiento = "{call SP_Eliminar_Ingredientes(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cIngrediente);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar ingrediente: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarIngrediente(int cIngrediente, int cSucursal, int cProveedor, String dIngrediente,
            double qActual, int cUnidadMedida) {
        String procedimiento = "{call SP_Actualizar_Ingredientes(?, ?, ?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cIngrediente);
            stmt.setInt(2, cSucursal);
            stmt.setInt(3, cProveedor);
            stmt.setString(4, dIngrediente);
            stmt.setDouble(5, qActual);
            stmt.setInt(6, cUnidadMedida);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar ingrediente: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<PagoProveedor> seleccionarPagosProveedores() {
        ArrayList<PagoProveedor> pagosProveedores = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Pagos_Proveedores}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cPagoProveedor = rs.getInt("C_Pago_Proveedor");
                int cProveedor = rs.getInt("C_Proveedor");
                double mPagoProveedor = rs.getDouble("M_Pago_Proveedor");

                PagoProveedor pagoProveedor = new PagoProveedor(cPagoProveedor, cProveedor, mPagoProveedor);
                pagosProveedores.add(pagoProveedor);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar pagos a proveedores: " + e.getMessage());
        }

        return pagosProveedores;
    }

    public boolean insertarPagoProveedor(int cProveedor, double mPagoProveedor) {
        String procedimiento = "{call SP_Insertar_Pagos_Proveedores(?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cProveedor);
            stmt.setDouble(2, mPagoProveedor);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar pago a proveedor: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarPagoProveedor(int cPagoProveedor) {
        String procedimiento = "{call SP_Eliminar_Pagos_Proveedores(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cPagoProveedor);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar pago a proveedor: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarPagoProveedor(int cPagoProveedor, int cProveedor, double mPagoProveedor) {
        String procedimiento = "{call SP_Actualizar_Pagos_Proveedores(?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cPagoProveedor);
            stmt.setInt(2, cProveedor);
            stmt.setDouble(3, mPagoProveedor);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar pago a proveedor: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<TipoProducto> seleccionarTiposProductos() {
        ArrayList<TipoProducto> tiposProductos = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Tipos_Productos}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cTipoProducto = rs.getInt("C_Tipo_Producto");
                String dTipoProducto = rs.getString("D_Tipo_Producto");

                TipoProducto tipoProducto = new TipoProducto(cTipoProducto, dTipoProducto);
                tiposProductos.add(tipoProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar tipos de productos: " + e.getMessage());
        }

        return tiposProductos;
    }

    public boolean insertarTipoProducto(String dTipoProducto) {
        String procedimiento = "{call SP_Insertar_Tipos_Productos(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setString(1, dTipoProducto);

            // Ejecutar la actualización
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar tipo de producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarTipoProducto(int cTipoProducto) {
        String procedimiento = "{call SP_Eliminar_Tipos_Productos(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cTipoProducto);

            // Ejecutar la actualización
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar tipo de producto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarTipoProducto(int cTipoProducto, String dTipoProducto) {
        String procedimiento = "{call SP_Actualizar_Tipos_Productos(?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cTipoProducto);
            stmt.setString(2, dTipoProducto);

            // Ejecutar la actualización
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar tipo de producto: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Combo> seleccionarCombos() {
        ArrayList<Combo> combos = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Combos}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cCombo = rs.getInt("C_Combo");
                String dCombo = rs.getString("D_Combo");

                Combo combo = new Combo(cCombo, dCombo);
                combos.add(combo);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar combos: " + e.getMessage());
        }

        return combos;
    }

    public boolean insertarCombo(String dCombo) {
        String procedimiento = "{call SP_Insertar_Combos(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            stmt.setString(1, dCombo);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar combo: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarCombo(int cCombo) {
        String procedimiento = "{call SP_Eliminar_Combos(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            stmt.setInt(1, cCombo);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar combo: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarCombo(int cCombo, String dCombo) {
        String procedimiento = "{call SP_Actualizar_Combos(?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            stmt.setInt(1, cCombo);
            stmt.setString(2, dCombo);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar combo: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Producto> seleccionarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Productos}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cProducto = rs.getInt("C_Producto");
                Integer cCombo = rs.getObject("C_Combo") != null ? rs.getInt("C_Combo") : null;
                int cSucursal = rs.getInt("C_Sucursal");
                int cTipoProducto = rs.getInt("C_Tipo_Producto");
                String dProducto = rs.getString("D_Producto");
                double mPrecio = rs.getDouble("M_Precio");

                Producto producto = new Producto(cProducto, cCombo, cSucursal, cTipoProducto, dProducto, mPrecio);
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar productos: " + e.getMessage());
        }

        return productos;
    }

    public boolean insertarProducto(Integer cCombo, int cSucursal, int cTipoProducto, String dProducto, double mPrecio) {
        String procedimiento = "{call SP_Insertar_Productos(?, ?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            if (cCombo != null) {
                stmt.setInt(1, cCombo);
            } else {
                stmt.setNull(1, java.sql.Types.TINYINT);
            }
            stmt.setInt(2, cSucursal);
            stmt.setInt(3, cTipoProducto);
            stmt.setString(4, dProducto);
            stmt.setDouble(5, mPrecio);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProducto(int cProducto) {
        String procedimiento = "{call SP_Eliminar_Productos(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cProducto);

            // Ejecutar la eliminación
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarProducto(int cProducto, Integer cCombo, int cSucursal, int cTipoProducto, String dProducto, double mPrecio) {
        String procedimiento = "{call SP_Actualizar_Productos(?, ?, ?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cProducto);
            if (cCombo != null) {
                stmt.setInt(2, cCombo);
            } else {
                stmt.setNull(2, java.sql.Types.TINYINT);
            }
            stmt.setInt(3, cSucursal);
            stmt.setInt(4, cTipoProducto);
            stmt.setString(5, dProducto);
            stmt.setDouble(6, mPrecio);

            // Ejecutar la actualización
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<DetallePedido> seleccionarDetallesPedido(int cPedido) {
        ArrayList<DetallePedido> detallesPedido = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Detalles_Pedido(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cPedido);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    int cDetallePedido = rs.getInt("C_Detalle_Pedido");
                    int cProducto = rs.getInt("C_Producto");
                    String nombreProducto = rs.getString("D_Producto");
                    byte qPedido = rs.getByte("Q_Pedido");
                    double mTotal = rs.getDouble("M_Total");

                    DetallePedido detallePedido = new DetallePedido(cDetallePedido, cPedido, cProducto, nombreProducto, qPedido, mTotal);
                    detallesPedido.add(detallePedido);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar detalles de pedido: " + e.getMessage());
        }

        return detallesPedido;
    }

    public boolean eliminarDetallePedido(int cDetallePedido) {
        String procedimiento = "{call SP_Eliminar_Detalles_Pedido(?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cDetallePedido);

            // Ejecutar la eliminación
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar detalle del pedido: " + e.getMessage());
            return false;
        }
    }

    public boolean insertarDetallePedido(int cPedido, int cProducto, int qPedido) {
        String procedimiento = "{call SP_Insertar_Detalle_Pedido(?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            stmt.setInt(1, cPedido);
            stmt.setInt(2, cProducto);
            stmt.setInt(3, qPedido);

            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar detalle de pedido: " + e.getMessage());
            return false;
        }
    }

    //productos
    public ArrayList<ProductoIngrediente> seleccionarProductosIngredientes() {
        ArrayList<ProductoIngrediente> productosIngredientes = new ArrayList<>();
        String procedimiento = "{call SP_Seleccionar_Productos_Ingredientes}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int cIngredientes = rs.getInt("C_Ingredientes");
                int cProductos = rs.getInt("C_Productos");
                int qConsumo = rs.getInt("Q_Consumo");
                int cUnidadMedida = rs.getInt("C_Unidad_Medida");

                ProductoIngrediente productoIngrediente = new ProductoIngrediente(cIngredientes, cProductos, qConsumo, cUnidadMedida);
                productosIngredientes.add(productoIngrediente);
            }
        } catch (SQLException e) {
            System.out.println("Error al seleccionar productos e ingredientes: " + e.getMessage());
        }

        return productosIngredientes;
    }

    public boolean insertarProductoIngrediente(int cIngredientes, int cProductos, double qConsumo, int cUnidadMedida) {
        String procedimiento = "{call SP_Insertar_Productos_Ingredientes(?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cIngredientes);
            stmt.setInt(2, cProductos);
            stmt.setDouble(3, qConsumo);
            stmt.setInt(4, cUnidadMedida);

            // Ejecutar la inserción
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al insertar producto ingrediente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminarProductoIngrediente(int cIngredientes, int cProductos) {
        String procedimiento = "{call SP_Eliminar_Productos_Ingredientes(?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cIngredientes);
            stmt.setInt(2, cProductos);

            // Ejecutar la eliminación
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto ingrediente: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarProductoIngrediente(int cIngredientes, int cProductos, double qConsumo, int cUnidadMedida) {
        String procedimiento = "{call SP_Actualizar_Productos_Ingredientes(?, ?, ?, ?)}";

        try (Connection con = Conexion.getConexion();
                CallableStatement stmt = con.prepareCall(procedimiento)) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cIngredientes);
            stmt.setInt(2, cProductos);
            stmt.setDouble(3, qConsumo);
            stmt.setInt(4, cUnidadMedida);

            // Ejecutar la actualización
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto ingrediente: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<ClientesSucursales> obtenerClientesSucursales() {
        ArrayList<ClientesSucursales> clientesSucursales = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Clientes_Sucursales}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar las relaciones clientes-sucursales a la lista
            while (rs.next()) {
                int cCliente = rs.getInt("C_Cliente");
                int cSucursales = rs.getInt("C_Sucursales");

                ClientesSucursales clienteSucursal = new ClientesSucursales(cCliente, cSucursales);
                clientesSucursales.add(clienteSucursal);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los clientes y sucursales: " + e.getMessage());
        }
        return clientesSucursales;
    }

    public boolean insertarClienteSucursal(int cCliente, int cSucursales) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Clientes_Sucursales(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cCliente);
            stmt.setInt(2, cSucursales);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente y sucursal: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarClienteSucursal(int cCliente, int cSucursales) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Clientes_Sucursales(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cCliente);
            stmt.setInt(2, cSucursales);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente y sucursal: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public ArrayList<Express> obtenerExpress() {
        ArrayList<Express> expressList = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Express}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar los registros de express a la lista
            while (rs.next()) {
                int cExpress = rs.getInt("C_Express");
                String dNombreExpress = rs.getString("D_Nombre_Express");
                String dDireccionCliente = rs.getString("D_Direccion_Cliente");

                Express express = new Express(cExpress, dNombreExpress, dDireccionCliente);
                expressList.add(express);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los registros de express: " + e.getMessage());
        }
        return expressList;
    }

    public boolean insertarExpress(String dNombreExpress, String dDireccionCliente) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Express(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setString(1, dNombreExpress);
            stmt.setString(2, dDireccionCliente);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar registro de express: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarExpress(int cExpress) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Express(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cExpress);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar registro de express: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarExpress(int cExpress, String dNombreExpress, String dDireccionCliente) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Express(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cExpress);
            stmt.setString(2, dNombreExpress);
            stmt.setString(3, dDireccionCliente);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar registro de express: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Pedido> obtenerPedidos() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Pedido}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar los registros de pedidos a la lista
            while (rs.next()) {
                int cPedido = rs.getInt("C_Pedido");
                int cMesa = rs.getObject("C_Mesa") != null ? rs.getInt("C_Mesa") : 0;
                int cEmpleado = rs.getInt("C_Empleado");
                int cExpress = rs.getObject("C_Express") != null ? rs.getInt("C_Express") : 0;
                int cCliente = rs.getInt("C_Cliente");
                int cSucursal = rs.getInt("C_Sucursal");
                Time fHoraSolicitud = rs.getTime("F_Hora_Solicitud");
                Time fHoraEntrega = rs.getTime("F_Hora_Entrega");

                Pedido pedido = new Pedido(cPedido, cMesa, cEmpleado, cExpress, cCliente, cSucursal, fHoraSolicitud, fHoraEntrega);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los pedidos: " + e.getMessage());
        }
        return pedidos;
    }

    public int insertarPedido(int cMesa, int cEmpleado, int cExpress, int cCliente, int cSucursal, Time fHoraSolicitud, Time fHoraEntrega) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Pedido(?, ?, ?, ?, ?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            if (cMesa != 0) {
                stmt.setInt(1, cMesa);
            } else {
                stmt.setNull(1, java.sql.Types.TINYINT);
            }
            stmt.setInt(2, cEmpleado);
            if (cExpress != 0) {
                stmt.setInt(3, cExpress);
            } else {
                stmt.setNull(3, java.sql.Types.TINYINT);
            }
            stmt.setInt(4, cCliente);
            stmt.setInt(5, cSucursal);
            stmt.setTime(6, fHoraSolicitud);
            stmt.setTime(7, fHoraEntrega);

            stmt.registerOutParameter(8, java.sql.Types.INTEGER);

            stmt.execute();

            int codigoPedido = stmt.getInt(8);

            return codigoPedido;
        } catch (SQLException e) {
            System.out.println("Error al insertar pedido: " + e.getMessage());
            return -1; // Indicar que la inserción falló
        }
    }

    public boolean eliminarPedido(int cPedido) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Pedido(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cPedido);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar pedido: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarPedido(int cPedido, int cMesa, int cEmpleado, int cExpress, int cCliente, int cSucursal, Time fHoraSolicitud, Time fHoraEntrega) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Pedido(?, ?, ?, ?, ?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cPedido);
            if (cMesa != 0) {
                stmt.setInt(2, cMesa);
            } else {
                stmt.setNull(2, java.sql.Types.TINYINT);
            }
            stmt.setInt(3, cEmpleado);
            if (cExpress != 0) {
                stmt.setInt(4, cExpress);
            } else {
                stmt.setNull(4, java.sql.Types.TINYINT);
            }
            stmt.setInt(5, cCliente);
            stmt.setInt(6, cSucursal);
            stmt.setTime(7, fHoraSolicitud);
            stmt.setTime(8, fHoraEntrega);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar pedido: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<MetodoPago> obtenerMetodosPago() {
        ArrayList<MetodoPago> metodosPago = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Metodo_Pago}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar los registros de métodos de pago a la lista
            while (rs.next()) {
                int cMetodoPago = rs.getInt("C_Metodo_Pago");
                String dMetodoPago = rs.getString("D_Metodo_Pago");

                MetodoPago metodoPago = new MetodoPago(cMetodoPago, dMetodoPago);
                metodosPago.add(metodoPago);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los métodos de pago: " + e.getMessage());
        }
        return metodosPago;
    }

    public boolean insertarMetodoPago(String dMetodoPago) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Metodo_Pago(?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setString(1, dMetodoPago);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar método de pago: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarMetodoPago(int cMetodoPago) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Metodo_Pago(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cMetodoPago);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar método de pago: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarMetodoPago(int cMetodoPago, String dMetodoPago) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Metodo_Pago(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cMetodoPago);
            stmt.setString(2, dMetodoPago);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar método de pago: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Mesa> obtenerMesas() {
        ArrayList<Mesa> mesas = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Mesa}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar las mesas a la lista
            while (rs.next()) {
                int cMesa = rs.getInt("C_Mesa");
                int nMesa = rs.getInt("N_Mesa");
                int nCapacidad = rs.getInt("N_Capacidad");

                Mesa mesa = new Mesa(cMesa, nMesa, nCapacidad);
                mesas.add(mesa);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las mesas: " + e.getMessage());
        }
        return mesas;
    }

    public boolean insertarMesa(int nMesa, int nCapacidad) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Mesa(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, nMesa);
            stmt.setInt(2, nCapacidad);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar mesa: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public boolean eliminarMesa(int cMesa) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Mesa(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cMesa);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar mesa: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarMesa(int cMesa, int nMesa, int nCapacidad) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Mesa(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cMesa);
            stmt.setInt(2, nMesa);
            stmt.setInt(3, nCapacidad);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar mesa: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<Impuesto> obtenerImpuestos() {
        ArrayList<Impuesto> impuestos = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Impuesto()}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar los registros de impuestos a la lista
            while (rs.next()) {
                int cImpuesto = rs.getInt("C_Impuesto");
                String dImpuesto = rs.getString("D_Impuesto");
                int dProcentajeImpuesto = rs.getInt("D_Procentaje_Impuesto");

                Impuesto impuesto = new Impuesto(cImpuesto, dImpuesto, dProcentajeImpuesto);
                impuestos.add(impuesto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los impuestos: " + e.getMessage());
        }
        return impuestos;
    }

    public boolean eliminarImpuesto(int cImpuesto) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Impuesto(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cImpuesto);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar impuesto: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarImpuesto(int cImpuesto, String dImpuesto, int dProcentajeImpuesto) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Impuesto(?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cImpuesto);
            stmt.setString(2, dImpuesto);
            stmt.setInt(3, dProcentajeImpuesto);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar impuesto: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public boolean insertarImpuesto(String dImpuesto, int dProcentajeImpuesto) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Impuesto(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setString(1, dImpuesto);
            stmt.setInt(2, dProcentajeImpuesto);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar impuesto: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public ArrayList<Factura> obtenerFacturas() {
        ArrayList<Factura> facturas = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Factura()}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar los registros de facturas a la lista
            while (rs.next()) {
                int cFactura = rs.getInt("C_Factura");
                int cPedido = rs.getInt("C_Pedido");
                int cMetodoPago = rs.getInt("C_Metodo_Pago");
                int cSucursal = rs.getInt("C_Sucursal");
                int cImpuesto = rs.getInt("C_Impuesto");
                Timestamp fFactura = rs.getTimestamp("F_Factura");
                double mTotal = rs.getDouble("M_Total");

                Factura factura = new Factura(cFactura, cPedido, cMetodoPago, cSucursal, cImpuesto, fFactura, mTotal);
                facturas.add(factura);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las facturas: " + e.getMessage());
        }
        return facturas;
    }

    public int insertarFactura(int cPedido, int cMetodoPago, int cSucursal, int cImpuesto) {
    try (Connection con = getConexion();
         CallableStatement stmt = con.prepareCall("{call SP_Insertar_Factura(?, ?, ?, ?, ?)}")) {

        // Establecer los parámetros del procedimiento almacenado
        stmt.setInt(1, cPedido);
        stmt.setInt(2, cMetodoPago);
        stmt.setInt(3, cSucursal);
        stmt.setInt(4, cImpuesto);
        
       stmt.registerOutParameter(5, java.sql.Types.INTEGER);
        // Ejecutar el procedimiento almacenado
        stmt.execute();
         int codigoFactura = stmt.getInt(5);
        return codigoFactura; // Indicar que la inserción fue exitosa
    } catch (SQLException e) {
        System.out.println("Error al insertar factura: " + e.getMessage());
        return -1; // Indicar que la inserción falló
    }
}

    public boolean eliminarFactura(int cFactura) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Eliminar_Factura(?)}")) {

            // Establecer el parámetro del procedimiento almacenado
            stmt.setInt(1, cFactura);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la eliminación fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al eliminar factura: " + e.getMessage());
            return false; // Indicar que la eliminación falló
        }
    }

    public boolean actualizarFactura(int cFactura, int cPedido, int cMetodoPago, int cSucursal, int cImpuesto, Date fFactura) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Actualizar_Factura(?, ?, ?, ?, ?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cFactura);
            stmt.setInt(2, cPedido);
            stmt.setInt(3, cMetodoPago);
            stmt.setInt(4, cSucursal);
            stmt.setInt(5, cImpuesto);
            stmt.setTimestamp(6, new java.sql.Timestamp(fFactura.getTime()));

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la actualización fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al actualizar factura: " + e.getMessage());
            return false; // Indicar que la actualización falló
        }
    }

    public ArrayList<ComboProducto> obtenerCombosProductos() {
        ArrayList<ComboProducto> combosProductos = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Seleccionar_Combos_Productos()}")) {

            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar las combinaciones de productos a la lista
            while (rs.next()) {
                int cCombo = rs.getInt("C_Combo");
                int cProducto = rs.getInt("C_Producto");

                ComboProducto comboProducto = new ComboProducto(cCombo, cProducto);
                combosProductos.add(comboProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener las combinaciones de productos: " + e.getMessage());
        }
        return combosProductos;
    }

    public boolean insertarComboProducto(int cCombo, int cProducto) {
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Insertar_Combos_Productos(?, ?)}")) {

            // Establecer los parámetros del procedimiento almacenado
            stmt.setInt(1, cCombo);
            stmt.setInt(2, cProducto);

            // Ejecutar el procedimiento almacenado
            stmt.execute();
            return true; // Indicar que la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println("Error al insertar combinación de producto: " + e.getMessage());
            return false; // Indicar que la inserción falló
        }
    }

    public ArrayList<VerFactura> obtenerDatosFacturas(int codigoFactura) {
        ArrayList<VerFactura> datosFacturas = new ArrayList<>();
        try (Connection con = getConexion();
                CallableStatement stmt = con.prepareCall("{call SP_Ver_Factura(?)}")) {
            stmt.setInt(1, codigoFactura);
            // Ejecutar el procedimiento almacenado
            ResultSet rs = stmt.executeQuery();

            // Iterar sobre los resultados y agregar los registros de facturas a la lista
            while (rs.next()) {
                String dDireccionFisica = rs.getString("D_Direccion_Fisica");
                String dSucursal = rs.getString("D_Sucursal");
                String nTelefono = rs.getString("N_Telefono");
                String dCorreoElectronico = rs.getString("D_Correo_Electronico");
                int cFactura = rs.getInt("C_Factura");
                Timestamp fFactura = rs.getTimestamp("F_Factura");
                String dNombreCompleto = rs.getString("D_Nombre_Completo");
                int cPedido = rs.getInt("C_Pedido");
                String dImpuesto = rs.getString("D_Impuesto");
                double qImpuesto = rs.getDouble("Q_Impuesto");
                double mTotalI = rs.getDouble("M_Total_I");

                VerFactura datosfactura = new VerFactura(dDireccionFisica, dSucursal, nTelefono, dCorreoElectronico, cFactura,
                        fFactura, dNombreCompleto, cPedido, dImpuesto, qImpuesto, mTotalI);
                datosFacturas.add(datosfactura);

                System.out.println("Direccion" + dDireccionFisica);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener los datos de facturas: " + e.getMessage());
        }
        return datosFacturas;
    }

}
