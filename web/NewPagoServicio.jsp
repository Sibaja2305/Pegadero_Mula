<%-- 
    Document   : NewPagoServicio
    Created on : 27/05/2024, 06:46:37 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Sucursal"%>
<%@page import="Clases.Servicios"%>
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
    <form style="margin-left: 10px"  action= "InsertValidationPagoServicio.jsp" method="post">
            <div>
                <h1 class="Title">insertar nuevo servicio</h1>
            </div>
            
            <select name="servicio">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Servicios> servicio = sql.getServicios(); 
                    for (Servicios servicios : servicio) {
                %>
                <option name="servicio" value="<%= servicios.getCodigoServicio() %>"><%= servicios.getNombreServicio() %></option>
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
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la sucursal:</label>
                <input type="number" id="monto" class="form-control" name="monto" placeholder="Monto del pago" step="0.01" required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la fecha:</label>
                <input type="datetime-local" id="nombre" class="form-control" name="fecha" required Style =" width: 40%">
            </div>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
