<%-- 
    Document   : NewCaja
    Created on : 27/05/2024, 09:57:01 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Cliente"%>
<%@page import="Clases.Express"%>
<%@page import="Clases.Empleado"%>
<%@page import="Clases.Mesa"%>
<%@page import="Clases.Sucursal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form style="margin-left: 10px"  action= "InsertValidationPedido.jsp" method="post">
            <div>
                <h1 class="Title">insertar Pedido</h1>
            </div>
            
            <select name="mesa">
                <option name="mesa" value="<%= "0" %>">Null</option>
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Mesa> mesas = sql.obtenerMesas(); 
                    for (Mesa mesa : mesas) {
                %>
                 
                <option name="mesa" value="<%= mesa.getC_Mesa() %>"><%= mesa.getN_Mesa() %></option>
                <%
                    }
                %>
            </select>
             <select name="empleado">
                <%
                   
                    ArrayList<Empleado> empleados = sql.seleccionarEmpleados(); 
                    for (Empleado empleado : empleados) {
                %>
                <option name="empleado" value="<%= empleado.getCodigoEmpleado() %>"><%= empleado.getNombre()+" "+empleado.getPrimerApellido() %></option>
                <%
                    }
                %>
            </select>
            
             <select name="express">
                  <option name="express" value="<%= "0" %>">Null</option>
                <%
                  
                    ArrayList<Express> expressList = sql.obtenerExpress(); 
                    for (Express express : expressList) {
                %>
               
                <option name="express" value="<%= express.getC_Express() %>"><%= express.getD_Nombre_Express()+", "+express.getD_Direccion_Cliente() %></option>
                <%
                    }
                %>
            </select>
             <select name="cliente">
                <%
                  
                    ArrayList<Cliente> clientes = sql.obtenerClientes(); 
                    for (Cliente cliente : clientes) {
                %>
                <option name="cliente" value="<%= cliente.getC_Cliente() %>"><%= cliente.getC_Cedula() %></option>
                <%
                    }
                %>
            </select>
             <select name="sucursal">
                <%
                  
                    ArrayList<Sucursal> sucursales = sql.obtenerSucursales(); 
                    for (Sucursal sucursal : sucursales) {
                %>
                <option name="sucursal" value="<%= sucursal.getCodigoSucursal() %>"><%= sucursal.getNombreSucursal() %></option>
                <%
                    }
                %>
            </select>
           
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la fecha:</label>
                <input type="time" id="nombre" class="form-control" name="horaSolicitud" required Style =" width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la fecha:</label>
                <input type="time" id="nombre" class="form-control" name="horaEntrega" required Style =" width: 40%">
            </div>
          


            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
