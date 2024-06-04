<%-- 
    Document   : Caja
    Created on : 27/05/2024, 09:52:18 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.MetodoPago"%>
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
         <h1>Metodo de Pago</h1>
         <a href="NewMetodoPago.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newMetodoPago" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<MetodoPago> list = sql.obtenerMetodosPago();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Metodo de Pago</th>
                        <th class="text-center" >Metodo de Pago</th>
                   

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getC_Metodo_Pago() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getD_Metodo_Pago() %></td>
                    
                        <td class="text-center">
                            <form action="EliminarMetodoPago.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Metodo_Pago() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarMetodoPago.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Metodo_Pago() %>">
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
