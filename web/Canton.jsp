<%-- 
    Document   : Canton
    Created on : 26/05/2024, 12:20:46 AM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Canton"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <h1>Canton</h1>
         <a href="NewCanton.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Canton> list = sql.obtenerCantones();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de canton</th>
                        <th class="text-center" >Canton</th>
                        <th class="text-center">codigo Provincia </th>
                        

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoCanton() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreCanton() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoProvincia() %></td>
                        <td class="text-center">
                            <form action="EliminarCanton.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteCanton" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoCanton() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarCanton.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateCanton" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoCanton() %>">
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
