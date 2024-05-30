<%-- 
    Document   : Distrito
    Created on : 26/05/2024, 08:00:27 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Distrito"%>
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
         <h1>Distrito</h1>
         <a href="NewDistrito.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Distrito> list = sql.getDistritos();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Distrito</th>
                        <th class="text-center" >Distrito</th>
                        <th class="text-center">Codigo Canton </th>
                        

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoDistrito() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreDistrito() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoCanton() %></td>
                        <td class="text-center">
                            <form action="EliminarDistrito.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteDistrito" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoDistrito() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarDistrito.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateDistrito" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoDistrito() %>">
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
