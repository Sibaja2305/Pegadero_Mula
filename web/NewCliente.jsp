<%-- 
    Document   : NewCanton
    Created on : 26/05/2024, 12:29:16 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.DireccionFisica"%>

<%@page import="conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form style="margin-left: 10px"  action= "InsertValidationCliente.jsp" method="post">
            <div>
                <h1 class="Title">Clientes</h1>
            </div>
            
            
            
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite la cedula:</label>
                <input type="text" id="nombre" class="form-control" name="cedula" placeholder="cedula" required Style =" width: 40%">
            </div>
             <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite el numero de telefono:</label>
                <input type="text" id="nombre" class="form-control" name="numero" placeholder="numero de telefono" required Style =" width: 40%">
            </div>
              <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Direccion:</label>
            <select name="direccion">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<DireccionFisica> direcciones = sql.obtenerDireccionesFisicas(); // Método que obtiene las provincias desde la base de datos
                    for (DireccionFisica direccion : direcciones) {
                %>
                <option name="direccion" value="<%= direccion.getCodigoDireccionFisica()%>"><%= direccion.getNombreDireccionFisica()%></option>
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
