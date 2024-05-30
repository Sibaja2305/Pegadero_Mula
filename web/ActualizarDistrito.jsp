<%-- 
    Document   : ActualizarDistrito
    Created on : 26/05/2024, 08:39:03 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Canton"%>
<%@page import="java.util.ArrayList"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ActualizarCanton</title>
    </head>
   <body>
        <%int codigo = Integer.parseInt(request.getParameter("updateDistrito"));%>
         <form style="margin-left: 10px"  action= "ActualizarValidationDistrito.jsp" method="post">
            <div>
                <h1 class="Title">Distrito</h1>
            </div>
            <div class="form-group">
                
                <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            </div>

            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite el nuevo nombre del Distrito:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="nuevo nombre Distrito" required Style =" width: 40%">
            </div>
             <select name="canton">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Canton> cantones = sql.obtenerCantones(); // Método que obtiene las provincias desde la base de datos
                    for (Canton canton : cantones) {
                %>
                <option name="canton" value="<%= canton.getCodigoCanton() %>"><%=canton.getNombreCanton() %></option>
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
