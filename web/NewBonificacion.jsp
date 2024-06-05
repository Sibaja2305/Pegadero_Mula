<%-- 
    Document   : NewBonificacion
    Created on : 30/05/2024, 12:49:01 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Empleado"%>
<%@page import="java.util.ArrayList"%>
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
        <form style="margin-left: 10px"  action= "InsertValidationBonificacion.jsp" method="post">
            <div>
                <h1 class="Title">Insertar Nuevo Empleado</h1>
            </div>

            <label>Empleado:</label>
            <select name="empleado">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Empleado> empleados = sql.seleccionarEmpleados();
                    for (Empleado empleado : empleados) {
                %>
                <option name="empleado" value="<%= empleado.getCodigoEmpleado() %>"><%= empleado.getNombre() %></option>
                <%
                    }
                %>
            </select>
            
            
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la fecha de bonificacion:</label>
                <input type="date" id="text" class="form-control" name="fecha"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el monton :</label>
                <input type="Number" id="text" class="form-control" name="monton"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el motivo de la bonificacion:</label>
                <input type="text" id="text" class="form-control" name="motivo"  required style="width: 40%">
            </div> 
           
            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
