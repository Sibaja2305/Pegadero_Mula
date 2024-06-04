<%-- 
    Document   : ActualizarDireccion
    Created on : 26/05/2024, 10:53:21 PM
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
        <title>Actualizar Direccion</title>
    </head>
    <body>
        <%int codigo = Integer.parseInt(request.getParameter("updatedireccion"));%>
         <form style="margin-left: 10px"  action= "ActualizarValidationDireccion.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar</h1>
            </div>
            <div class="form-group">
                
                <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            </div>

            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite la nueva direccion:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="nueva Direccion" required Style =" width: 40%">
            </div>
             <select name="direccion">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Distrito> distritos = sql.getDistritos(); // Método que obtiene las provincias desde la base de datos
                    for (Distrito distrito : distritos) {
                %>
                <option name="direccion" value="<%= distrito.getCodigoDistrito() %>"><%=distrito.getNombreDistrito() %></option>
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
