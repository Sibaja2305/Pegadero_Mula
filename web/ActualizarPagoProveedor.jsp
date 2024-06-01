<%-- 
    Document   : ActualizarPagoProveedor
    Created on : 31/05/2024, 01:29:45 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Proveedor"%>
<%@page import="Clases.Proveedor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%int codigo = Integer.parseInt(request.getParameter("update"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationPagoProveedor.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar</h1>
            </div>
            <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >

                 <select name="proveedor">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Proveedor> proveedores = sql.seleccionarProveedores();
                    for (Proveedor proveedor : proveedores) {
                %>
                <option name="proveedor" value="<%= proveedor.getCodigoProveedor() %>"><%= proveedor.getProveedor() %></option>
                <%
                    }
                %>
            </select>
            
           <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Valor:</label>
                <input type="Number" id="text" class="form-control" name="actual"  required style="width: 40%">
            </div>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body> 
</html>
