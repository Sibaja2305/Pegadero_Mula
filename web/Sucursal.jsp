<%-- 
    Document   : Sucursal
    Created on : 26/05/2024, 11:44:38 PM
    Author     : Hp EliteBook
--%>

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
         <h1>Sucursales</h1>
         <a href="NewSucursal.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Sucursal> list = sql.obtenerSucursales();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo Sucursal</th>
                        <th class="text-center" >Nombre de Sucursal</th>
                        <th class="text-center">Telefono</th>
                        <th class="text-center">Correo Electronico</th>
                        <th class="text-center">Codigo direccion</th>

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoSucursal() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreSucursal() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getTelefono() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCorreoElectronico() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoDireccionFisica() %></td>
                        
                        <td class="text-center">
                            <form action="EliminarSucursal.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteSucursal" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoSucursal() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarSucursal.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateSucursal" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoSucursal() %>">
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
