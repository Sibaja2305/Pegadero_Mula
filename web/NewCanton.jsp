<%-- 
    Document   : NewCanton
    Created on : 26/05/2024, 12:29:16 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Provincia"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form style="margin-left: 10px"  action= "InsertValidationCanton.jsp" method="post">
            <div>
                <h1 class="Title">Cantones</h1>
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite el nombre del canton:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="nombre canton" required Style =" width: 40%">
            </div>
            <select name="provincia">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Provincia> provincias = sql.getProvincias(); // Método que obtiene las provincias desde la base de datos
                    for (Provincia provincia : provincias) {
                %>
                <option name="provincia" value="<%= provincia.getCodigoProvincia()%>"><%= provincia.getNombreProvincia()%></option>
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
