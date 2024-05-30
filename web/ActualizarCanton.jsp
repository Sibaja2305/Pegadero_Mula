<%-- 
    Document   : ActualizarCanton
    Created on : 26/05/2024, 12:59:27 AM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Provincia"%>
<%@page import="Clases.Provincia"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%int codigo = Integer.parseInt(request.getParameter("updateCanton"));%>
         <form style="margin-left: 10px"  action= "ActualizarValidationCanton.jsp" method="post">
            <div>
                <h1 class="Title">Provincia</h1>
            </div>
            <div class="form-group">
                
                <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            </div>

            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite el nuevo nombre de la canton:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="nuevo nombre canton" required Style =" width: 40%">
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
