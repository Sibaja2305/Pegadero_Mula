<%-- 
    Document   : NewProductoIngrediente
    Created on : 31/05/2024, 06:34:19 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.UnidadMedida"%>
<%@page import="Clases.Producto"%>
<%@page import="Clases.Ingredientes"%>
<%@page import="java.util.ArrayList"%>
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
        <form style="margin-left: 10px"  action= "InsertValidationProductoIngrediente.jsp" method="post">
            <div>
                <h1 class="Title">Insertar</h1>
            </div>
            <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Ingrediente:</label>
            <select name="ingrediente">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Ingredientes> ingredientes = sql.seleccionarIngredientes();
                    for (Ingredientes ingrediente : ingredientes) {
                %>
                <option name="ingrediente" value="<%= ingrediente.getCodigoIngrediente() %>"><%=ingrediente.getNombreIngrediente()%></option>
                <%
                    }
                %>
            </select>
           <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Producto:</label>
              <select name="producto">
                <%
                    
                    ArrayList<Producto> productos = sql.seleccionarProductos();
                    for (Producto producto : productos) {
                %>
                <option name="producto" value="<%= producto.getCodigoProducto() %>"><%= producto.getNombreProducto() %></option>
                <%
                    }
                %>
            </select>
           
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">cantidad de consumo:</label>
                <input type="text" id="text" class="form-control" name="consumo" pattern="\d+(\.\d+)?" required style="width: 40%">
            </div>
            <label>Medida</label>
              <select name="unidadMedida">
                <%
                    
                    ArrayList<UnidadMedida> unidades = sql.seleccionarUnidadesMedida();
                    for (UnidadMedida unidadMedida : unidades) {
                %>
                <option name="unidadMedida" value="<%= unidadMedida.getCodigoUnidadMedida() %>"><%= unidadMedida.getUnidadMedidad() %></option>
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
