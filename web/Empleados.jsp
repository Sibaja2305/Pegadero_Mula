<%-- 
    Document   : Empleados
    Created on : 27/05/2024, 11:51:58 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Empleado"%>
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
        <a href="NewEmpleado.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                ArrayList<Empleado> list = sql.seleccionarEmpleados();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo Empleado</th>
                        <th class="text-center" >Codigo Rol</th>
                        <th class="text-center" >Codigo hora extras</th>
                        <th class="text-center" >Codigo Sucursal</th>
                        <th class="text-center" >Cedula</th>
                        <th class="text-center" >Nombre</th>
                        <th class="text-center" >Primer Apellido</th>
                        <th class="text-center" >Segundo Apellido</th>
                        <th class="text-center" >salario</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoEmpleado() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoRol() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getHorasExtras() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoSucursal() %></td> 
                        <td class="align-middle text-center"><%=list.get(i).getIdentificacion() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombre() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getPrimerApellido() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getSegundoApellido() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getSalario() %></td>
                        <td>
                            <form action="EliminarEmpleado.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteEmpleado" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoEmpleado()%>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarEmpleado.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateEmpleado" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoEmpleado()%>">
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
