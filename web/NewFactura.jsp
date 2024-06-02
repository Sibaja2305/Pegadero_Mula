<%-- 
    Document   : NewDetallePedido
    Created on : 31/05/2024, 06:04:50 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Impuesto"%>
<%@page import="Clases.Sucursal"%>
<%@page import="Clases.MetodoPago"%>
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
        <form style="margin-left: 10px"  action= "InsertValidationFactura.jsp" method="post">
            <div>
                <h1 class="Title">insertar Factura</h1>
            </div>
             <input  type="text" hidden class="form-control" name="codigoPedido" value=<%=codigoPedido%> required Style ="width: 40%" >
            <select name="metodoPago">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<MetodoPago> metodos = sql.obtenerMetodosPago();
                    for (MetodoPago metodo : metodos) {
                %>
                <option name="metodoPago" value="<%= metodo.getC_Metodo_Pago() %>"><%= metodo.getD_Metodo_Pago() %></option>
                <%
                    }
                %>
            </select>
             <select name="sucursal">
                <%
                    
                    ArrayList<Sucursal> sucursales = sql.obtenerSucursales();
                    for (Sucursal sucursal : sucursales) {
                %>
                <option name="sucursal" value="<%= sucursal.getCodigoSucursal() %>"><%= sucursal.getNombreSucursal() %></option>
                <%
                    }
                %>
            </select>
            <select name="impuesto">
                <%
                    
                    ArrayList<Impuesto> impuestos = sql.obtenerImpuestos();
                    for (Impuesto impuesto : impuestos) {
                %>
                <option name="impuesto" value="<%= impuesto.getC_Impuesto() %>"><%= impuesto.getD_Impuesto() %></option>
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
