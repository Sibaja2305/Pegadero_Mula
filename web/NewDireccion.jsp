<%-- 
    Document   : NewDireccion
    Created on : 26/05/2024, 10:33:10 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Distrito"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Nueva Direccion</title>
    </head>
    <body>
        <form style="margin-left: 10px"  action= "InsertValidationDireccion.jsp" method="post">
            <div>
                <h1 class="Title">Direccion</h1>
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite la direccion:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="Direccion" required Style =" width: 40%">
            </div>
             <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Seleccione el Distrito:</label>
            <select name="direccion">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Distrito> distritos = sql.getDistritos(); 
                    for (Distrito distrito : distritos) {
                %>
                <option name="direccion" value="<%= distrito.getCodigoDistrito() %>"><%= distrito.getNombreDistrito() %></option>
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
