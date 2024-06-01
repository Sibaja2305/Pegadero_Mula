<%-- 
    Document   : Vacaciones
    Created on : 30/05/2024, 01:46:55 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Vacaciones"%>
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
        <h1>Empleados</h1>
        <a href="NewVacaciones.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                ArrayList<Vacaciones> list = sql.seleccionarVacaciones();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Vacaciones</th>
                        <th class="text-center" >Codigo de Empleado</th>
                        <th class="text-center" >Fecha de inicio</th>
                        <th class="text-center" >Fecha de Fin</th>
                        
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoVacaciones() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoEmpleado() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaInicio() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaFin() %></td> 
                       
                    
                        <td>
                            <form action="EliminarVacaciones.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoVacaciones() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarVacaciones.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoVacaciones()%>">
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
