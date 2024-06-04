<%-- 
    Document   : NewPagoProveedor
    Created on : 31/05/2024, 01:23:41 AM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Proveedor"%>
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
        <form style="margin-left: 10px"  action= "InsertValidationPagoProveedor.jsp" method="post">
            <div>
                <h1 class="Title">insertar nuevo Pago proveedor</h1>
            </div>
            
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
