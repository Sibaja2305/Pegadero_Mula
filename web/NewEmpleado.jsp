<%-- 
    Document   : NewEmpleado
    Created on : 28/05/2024, 12:00:14 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.HorasExtras"%>
<%@page import="Clases.RolEmpleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Sucursal"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form style="margin-left: 10px"  action= "InsertValidationEmpleado.jsp" method="post">
            <div>
                <h1 class="Title">insertar nuevo empleado</h1>
            </div>

            <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Sucursal:</label>
            <select name="sucursal">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Sucursal> sucursales = sql.obtenerSucursales();
                    for (Sucursal sucursal : sucursales) {
                %>
                <option name="sucursal" value="<%= sucursal.getCodigoSucursal()%>"><%= sucursal.getNombreSucursal()%></option>
                <%
                    }
                %>
            </select>
            <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Rol del empleado:</label>
            <select name="rol">
                <%
                    ArrayList<RolEmpleado> roles = sql.getRolesEmpleado();
                    for (RolEmpleado rolEmpleado : roles) {
                %>
                <option name="rol" value="<%= rolEmpleado.getCodigoRol()%>"><%= rolEmpleado.getRol()%></option>
                <%
                    }
                %>
            </select>
            <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Horas Extras:</label>
            <select name="horas">
                <option value="">Seleccione una opción</option>
                <%
                    ArrayList<HorasExtras> horas = sql.getHorasExtra();
                    for (HorasExtras hora : horas) {
                %>
                <option value="<%= hora.getCodigoHoraExtra()%>"><%= hora.getCantidadHoras()%></option>
                <%
                    }
                %>
            </select>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite su identificacion:</label>
                <input type="text" id="text" class="form-control" name="identicacion"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite su nombre:</label>
                <input type="text" id="text" class="form-control" name="nombre"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite su primer apellido:</label>
                <input type="text" id="text" class="form-control" name="primerApellido"  required style="width: 40%">
            </div> 
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite su segundo apellido:</label>
                <input type="text" id="fecha" class="form-control" name="segundoApellido"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el salario:</label>
                <input type="number" id="salario" class="form-control" name="salario"  required style="width: 40%">
            </div>
            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
