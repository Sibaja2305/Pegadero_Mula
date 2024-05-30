<%-- 
    Document   : Provincia
    Created on : 25/05/2024, 10:18:21 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Provincia"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Provincia</h1>
         <a href="NewProvincia.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Provincia> list = sql.getProvincias();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo</th>
                        <th class="text-center" >Provincia</th>
                        

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoProvincia() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreProvincia() %></td>
                    
                        <td class="text-center">
                            <form action="EliminarProvincia.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteprovincia" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProvincia() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarProvincia.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateprovincia" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProvincia() %>">
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
