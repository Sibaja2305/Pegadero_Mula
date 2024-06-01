<%-- 
    Document   : Bonificaciones
    Created on : 30/05/2024, 12:22:07 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Bonificacion"%>
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
        <a href="NewBonificacion.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                ArrayList<Bonificacion> list = sql.seleccionarBonificaciones();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo Bonificacion</th>
                        <th class="text-center" >Fecha de Bonificacion</th>
                        <th class="text-center" >Monto de bonificacion</th>
                        <th class="text-center" >Motivo</th>
                        <th class="text-center" >Codigo empleado</th>
                        
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoBonificacion() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaBonificacion() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getMontoBonificacion() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getMotivoBonificacion() %></td> 
                        <td class="align-middle text-center"><%=list.get(i).getCodigoEmpleado() %></td>
                    
                        <td>
                            <form action="EliminarBonificacion.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoBonificacion() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarBonificacion.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoBonificacion()%>">
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
