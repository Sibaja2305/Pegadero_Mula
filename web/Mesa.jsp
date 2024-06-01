<%-- 
    Document   : Canton
    Created on : 26/05/2024, 12:20:46 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Mesa"%>

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
         <h1>Mesa</h1>
         <a href="NewMesa.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Mesa> list = sql.obtenerMesas();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de mesa</th>
                        <th class="text-center" >Numero de mesa</th>
                        <th class="text-center">capacidad</th>
                       
                        

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getC_Mesa() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getN_Mesa() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getN_Capacidad() %></td>
                        
                        <td class="text-center">
                            <form action="EliminarMesa.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Mesa()%>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarMesa.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Mesa() %>">
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
