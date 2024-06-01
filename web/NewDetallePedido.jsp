<%-- 
    Document   : NewDetallePedido
    Created on : 31/05/2024, 06:04:50 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Producto"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
        <%int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));%>
        <form style="margin-left: 10px"  action= "InsertValidationDetallePedido.jsp" method="post">
            <div>
                <h1 class="Title">insertar detalle de pedido</h1>
            </div>
             <input  type="text" hidden class="form-control" name="codigoPedido" value=<%=codigoPedido%> required Style ="width: 40%" >
            <select name="producto">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Producto> productos = sql.seleccionarProductos();
                    for (Producto producto : productos) {
                %>
                <option name="producto" value="<%= producto.getCodigoProducto() %>"><%= producto.getNombreProducto() %></option>
                <%
                    }
                %>
            </select>
            
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">cantidad</label>
                <input type="Number" id="text" class="form-control" name="total"  required style="width: 40%">
            </div>
            

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
