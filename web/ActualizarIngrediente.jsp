<%-- 
    Document   : ActualizarIngrediente
    Created on : 31/05/2024, 12:55:21 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.UnidadMedida"%>
<%@page import="Clases.Proveedor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Sucursal"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <%int codigo = Integer.parseInt(request.getParameter("update"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationIngrediente.jsp" method="post">
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
                <option name="sucursal" value="<%= sucursal.getCodigoSucursal() %>"><%= sucursal.getNombreSucursal() %></option>
                <%
                    }
                %>
                 <select name="proveedor">
                <%
                    
                    ArrayList<Proveedor> proveedores = sql.seleccionarProveedores();
                    for (Proveedor proveedor : proveedores) {
                %>
                <option name="proveedor" value="<%= proveedor.getCodigoProveedor() %>"><%= proveedor.getProveedor() %></option>
                <%
                    }
                %>
            </select>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Ingrediente:</label>
                <input type="text" id="text" class="form-control" name="Nombre"  required style="width: 40%">
            </div>
           <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Valor:</label>
                <input type="Number" id="text" class="form-control" name="actual"  required style="width: 40%">
            </div>
             <select name="unidad">
                <%
                    
                    ArrayList<UnidadMedida> unidades = sql.seleccionarUnidadesMedida();
                    for (UnidadMedida unidad : unidades) {
                %>
                <option name="unidad" value="<%= unidad.getCodigoUnidadMedida() %>"><%=unidad.getUnidadMedidad() %></option>
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
