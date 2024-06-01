<%-- 
    Document   : NewIngrediente
    Created on : 31/05/2024, 12:37:13 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.UnidadMedida"%>
<%@page import="Clases.Proveedor"%>
<%@page import="Clases.Sucursal"%>
<%@page import="java.util.ArrayList"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
     <body>
        <form style="margin-left: 10px"  action= "InsertValidationIngrediente.jsp" method="post">
            <div>
                <h1 class="Title">insertar nuevo ingrediente</h1>
            </div>
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
              </select>
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
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Cantidad:</label>
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
