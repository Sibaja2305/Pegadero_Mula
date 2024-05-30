<%-- 
    Document   : ActualizarSucursal
    Created on : 27/05/2024, 04:09:29 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.DireccionFisica"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%int codigo = Integer.parseInt(request.getParameter("updateSucursal"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationSucursal.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar/h1>
            </div>
            <div class="form-group">
                
                <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la sucursal:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="sucursal" required Style =" width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el telefono:</label>
                <input type="text" id="nombre" class="form-control" name="telefono" placeholder="telefono" required Style =" width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el correo:</label>
                <input type="text" id="nombre" class="form-control" name="correo" placeholder="example@gmail.com" required Style =" width: 40%">
            </div>
            <select name="direccion">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<DireccionFisica> direcciones = sql.obtenerDireccionesFisicas(); 
                    for (DireccionFisica direccion : direcciones) {
                %>
                <option name="direccion" value="<%=direccion.getCodigoDireccionFisica() %>"><%= direccion.getNombreDireccionFisica() %></option>
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
