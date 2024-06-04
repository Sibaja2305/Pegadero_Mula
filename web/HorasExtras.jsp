<%-- 
    Document   : HorasExtras
    Created on : 27/05/2024, 11:06:57 PM
    Author     : Hp EliteBook
--%>


<%@page import="Clases.HorasExtras"%>
<%@page import="java.util.ArrayList"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Horas Extras</h1>
        <a href="NewHoraExtra.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                ArrayList<HorasExtras> list = sql.getHorasExtra();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo hora extras</th>
                        <th class="text-center" >fecha</th>
                        <th class="text-center" >cantidad de horas</th>

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoHoraExtra()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaHoraExtra() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCantidadHoras() %></td>
                        <td>
                            <form action="EliminarHoraExtra.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteHoras" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoHoraExtra()%>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarHorasExtras.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateHoras" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoHoraExtra()%>">
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
