<%-- 
    Document   : ActualizarVacaciones
    Created on : 30/05/2024, 02:16:15 PM
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
        <%int codigo = Integer.parseInt(request.getParameter("update"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationVacaciones.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar</h1>
            </div>
            <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            <label>Empleado</label>
            <select name="empleado">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Empleado> empleados = sql.seleccionarEmpleados();
                    for (Empleado empleado : empleados) {
                %>
                <option name="empleado" value="<%= empleado.getCodigoEmpleado()%>"><%= empleado.getNombre()%></option>
                <%
                    }
                %>
            </select>


            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">seleccione la fecha de inicio:</label>
                <input type="date" id="text" class="form-control" name="fechaInicio"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">selecione la fecha de fin :</label>
                <input type="date" id="text" class="form-control" name="FechaFin"  required style="width: 40%">
            </div>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
