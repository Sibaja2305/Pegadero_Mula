/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            Connection con = DriverManager.getConnection(conexionUrl);
            return con;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
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
                Cliente cliente = new Cliente( nombre, primerApellido, segundoApellido);
                clientes.add(cliente);
            }
        }
        
        return clientes; // Devolver el ArrayList de clientes
    }
    
    return null; // En caso de conexión nula
}
   
         
   }
     
     

