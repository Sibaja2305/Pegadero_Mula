<%-- 
    Document   : Canton
    Created on : 26/05/2024, 12:20:46 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Express"%>

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
         <h1>Express</h1>
         <a href="NewExpress.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Express> list = sql.obtenerExpress();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Express</th>
                        <th class="text-center" >Nombre de Express</th>
                        <th class="text-center">Direccion_cliente</th>
                     
                        

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getC_Express() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getD_Nombre_Express() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getD_Direccion_Cliente() %></td>
                       
                        <td class="text-center">
                            <form action="EliminarExpress.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Express() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarExpress.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Express() %>">
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
