<%-- 
    Document   : ProductoIngrediente
    Created on : 31/05/2024, 06:29:26 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.ProductoIngrediente"%>
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
        <h1>Productos ingredientes</h1>
        <a href="NewProductoIngrediente.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                    ArrayList<ProductoIngrediente> list = sql.seleccionarProductosIngredientes();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Ingrediente</th>
                        <th class="text-center" >Codigo Producto</th>
                        <th class="text-center" >consumo</th>
                        <th class="text-center" >Codigo de Unidad de Medida</th>
                       
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoIngredientes() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoProducto() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCantidadConsumo() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoUnidadMedida() %></td>
                        
                        <td>
                            <form action="EliminarProductoIngrediente.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteP" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProducto() %>">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteI" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoIngredientes() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarProductoIngrediente.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateP" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProducto()%>">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateI" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoIngredientes() %>">
                                <input                                        
                                    class="btn btn-info btn-sm" 
                                    type="submit"                                                                              
                                    value="actualizar" >
                            </form>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
    </body>
</html>
