<%-- 
    Document   : RolesEmpleados
    Created on : 27/05/2024, 10:29:50 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.RolEmpleado"%>
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
         <h1>Roles empleados</h1>
         <a href="NewRolEmpleado.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<RolEmpleado> list = sql.getRolesEmpleado();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Rol</th>
                        <th class="text-center" >Rol</th>
                       

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoRol() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getRol() %></td>
                <td>
                            <form action="EliminarRolEmpleado.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteRol" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoRol() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarRolEmpleado.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateRol" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoRol() %>">
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
