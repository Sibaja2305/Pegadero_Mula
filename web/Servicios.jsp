<%-- 
    Document   : Servicios
    Created on : 27/05/2024, 04:33:04 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Servicios"%>
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
         <h1>Servicios</h1>
         <a href="NewServicio.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Servicios> list = sql.getServicios();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo Servicio</th>
                        <th class="text-center" >Nombre</th>
                        <th class="text-center">Fecha Vencimiento</th>

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoServicio() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreServicio() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaVencimiento() %></td>
                        <td class="text-center">
                            <form action="EliminarServicio.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteServicio" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoServicio() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarServicio.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateServicio" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoServicio() %>">
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
