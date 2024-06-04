<%-- 
    Document   : Caja
    Created on : 27/05/2024, 09:52:18 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Pedido"%>
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
         <h1>Pedido</h1>
         <a href="NewPedido.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newPedido" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Pedido> list = sql.obtenerPedidos();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo Pedido</th>
                        <th class="text-center" >Codigo de Mesa</th>
                        <th class="text-center">Codido de Empleado</th>
                        <th class="text-center">Codigo de Express</th>
                        <th class="text-center">Codigo de Cliente</th>
                        <th class="text-center">Codigo de Sucursal</th>
                         <th class="text-center">Hora de solicitud</th>
                        <th class="text-center">Hora de Entrega</th>

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getcPedido() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getcMesa() != 0 ?list.get(i).getcMesa():"Null"  %></td>
                        <td class="align-middle text-center"><%=list.get(i).getcEmpleado() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getcExpress()!= 0 ? list.get(i).getcExpress():"Null"  %></td>
                        <td class="align-middle text-center"><%=list.get(i).getcCliente() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getcSucursal() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getHoraSolucitud() %></td>
                         <td class="align-middle text-center"><%=list.get(i).getHoraEntrega() %></td>
                        <td class="text-center">
                            <form action="EliminarPedido.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getcPedido() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarPedido.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getcPedido() %>">
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
