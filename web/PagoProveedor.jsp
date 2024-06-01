<%-- 
    Document   : PagoProveedor
    Created on : 31/05/2024, 01:09:27 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.PagoProveedor"%>
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
        <h1>Ingredientes</h1>
        <a href="NewPagoProveedor.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                    ArrayList<PagoProveedor> list = sql.seleccionarPagosProveedores();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Pago de proveedor</th>
                        <th class="text-center" >Codigo Proveedor</th>
                        <th class="text-center" >Monton de pago Proveedor</th>
                        
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoPagoProveedor() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoProveedor() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getMontonPagoProveedor() %></td>
                        
                        <td>
                            <form action="EliminarPagoProveedor.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoPagoProveedor() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarPagoProveedor.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoPagoProveedor()%>">
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
