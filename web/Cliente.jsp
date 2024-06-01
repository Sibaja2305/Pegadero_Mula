<%-- 
    Document   : Canton
    Created on : 26/05/2024, 12:20:46 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Cliente"%>
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
         <h1>Cliente</h1>
         <a href="NewClientesSucursales.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Cliente> list = sql.obtenerClientes();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de cliente</th>
                        <th class="text-center" >Codigo de direccion fisica</th>
                        <th class="text-center">Cedula</th>
                         <th class="text-center">Numero de telefono </th>
                        

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getC_Cliente() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getC_Direccion_Fisica() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getC_Cedula() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getN_Numero_Telefono()%></td>
                        <td class="text-center">
                            <form action="EliminarCliente.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Cliente() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarCliente.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Cliente() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
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
