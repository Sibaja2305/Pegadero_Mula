<%-- 
    Document   : NewCanton
    Created on : 26/05/2024, 12:29:16 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Sucursal"%>
<%@page import="Clases.Cliente"%>
<%@page import="Clases.DireccionFisica"%>

<%@page import="conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form style="margin-left: 10px"  action= "InsertValidationClientesSucursales.jsp" method="post">
            <div>
                <h1 class="Title">Insertar Clientes Sucursales</h1>
            </div>
            
            
            <select name="cliente">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Cliente> clientes = sql.obtenerClientes(); // Método que obtiene las provincias desde la base de datos
                    for (Cliente cliente : clientes) {
                %>
                <option name="cliente" value="<%= cliente.getC_Cliente()%>"><%= cliente.getC_Cliente()%></option>
                <%
                    }
                %>
            </select>
           
            <select name="sucursal">
                <%
                    
                    ArrayList<Sucursal> sucursales = sql.obtenerSucursales(); // Método que obtiene las provincias desde la base de datos
                    for (Sucursal sucursal : sucursales) {
                %>
                <option name="sucursal" value="<%= sucursal.getCodigoSucursal()%>"><%= sucursal.getCodigoSucursal()%></option>
                <%
                    }
                %>
            </select>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
