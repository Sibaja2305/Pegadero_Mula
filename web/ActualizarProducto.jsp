<%-- 
    Document   : ActualizarProducto
    Created on : 31/05/2024, 05:30:04 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Sucursal"%>
<%@page import="conexion.Conexion"%>
<%@page import="Clases.Combo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.TipoProducto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%int codigo = Integer.parseInt(request.getParameter("update"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationProducto.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar</h1>
            </div>
            <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >


            <select name="sucursal">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Sucursal> sucursales = sql.obtenerSucursales();
                    for (Sucursal sucursal : sucursales) {
                %>
                <option name="sucursal" value="<%= sucursal.getCodigoSucursal()%>"><%= sucursal.getNombreSucursal()%></option>
                <%
                    }
                %>
            </select>
            <select name="combo">
                <option value="">Seleccionar Combo</option>
                <%
                    ArrayList<Combo> combos = sql.seleccionarCombos();
                    for (Combo combo : combos) {
                %>
                <option value="<%= combo.getCodigoCombo()%>"><%= combo.getNombreCombo()%></option>
                <% } %>
            </select>
              <select name="tipoProducto">
                <%
                    
                    ArrayList<TipoProducto> tipos = sql.seleccionarTiposProductos();
                    for (TipoProducto tipo : tipos) {
                %>
                <option name="tipoProducto" value="<%= tipo.getCodigoTipoProducto() %>"><%= tipo.getTipoProducto() %></option>
                <%
                    }
                %>
            </select>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">nombre del producto</label>
                <input type="text" id="text" class="form-control" name="Nombre"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Precio:</label>
                <input type="Number" id="text" class="form-control" name="precio"  required style="width: 40%">
            </div>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body> 
</html>
