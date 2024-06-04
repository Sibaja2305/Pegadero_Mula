<%-- 
    Document   : NewCanton
    Created on : 26/05/2024, 12:29:16 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Producto"%>
<%@page import="Clases.Combo"%>


<%@page import="conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form style="margin-left: 10px"  action= "InsertValidationComboProducto.jsp" method="post">
            <div>
                <h1 class="Title">Insertar Combo Producto</h1>
            </div>
            
            
            <select name="combo">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Combo> combos = sql.seleccionarCombos(); // Método que obtiene las provincias desde la base de datos
                    for (Combo combo : combos) {
                %>
                <option name="combo" value="<%= combo.getCodigoCombo()%>"><%= combo.getCodigoCombo()%></option>
                <%
                    }
                %>
            </select>
           
            <select name="producto">
                <%
                    
                    ArrayList<Producto> productos = sql.seleccionarProductos(); // Método que obtiene las provincias desde la base de datos
                    for (Producto producto : productos) {
                %>
                <option name="producto" value="<%= producto.getCodigoProducto()%>"><%= producto.getCodigoProducto()%></option>
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
