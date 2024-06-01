<%-- 
    Document   : Ingredientes
    Created on : 31/05/2024, 12:07:04 AM
    Author     : Hp EliteBook
--%>

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
        <h1>Ingredientes</h1>
        <a href="NewIngrediente.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                    ArrayList<Ingredientes> list = sql.seleccionarIngredientes();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de ingredientes</th>
                        <th class="text-center" >Codigo Sucursal</th>
                        <th class="text-center" >Codigo Proveedor</th>
                        <th class="text-center" >ingrediente</th>
                         <th class="text-center"> Cantida actual</th>
                         <th class="text-center" >Codigo Unidad Medida</th>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoIngrediente() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoSucursal()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoProveedor() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreIngrediente() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCantidad() %></td>
                    <td class="align-middle text-center"><%=list.get(i).getCodigoUnidadMedida() %></td>
                        <td>
                            <form action="EliminarIngrediente.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoIngrediente() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarIngrediente.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoIngrediente()%>">
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
