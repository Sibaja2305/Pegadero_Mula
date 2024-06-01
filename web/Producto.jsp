<%-- 
    Document   : Producto
    Created on : 31/05/2024, 11:27:13 AM
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
        <h1>Productos</h1>
        <a href="NewProducto.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                    ArrayList<Producto> list = sql.seleccionarProductos();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Producto</th>
                        <th class="text-center" >Codigo Combo</th>
                        <th class="text-center" >Codigo Sucursal</th>
                        <th class="text-center" >Codigo Tipo producto</th>
                         <th class="text-center"> Nombre Producto</th>
                         <th class="text-center" >Precio</th>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoProducto() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoCombo() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoSucursal() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoTipoProducto() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreProducto() %></td>
                    <td class="align-middle text-center"><%=list.get(i).getPrecio() %></td>
                        <td>
                            <form action="EliminarProducto.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProducto() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarProducto.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProducto()%>">
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
