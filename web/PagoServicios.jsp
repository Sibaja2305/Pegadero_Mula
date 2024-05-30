<%-- 
    Document   : PagoServicios
    Created on : 27/05/2024, 06:31:59 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.PagosServicios"%>
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
         <h1>Pago Servicios</h1>
         <a href="NewPagoServicio.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<PagosServicios> list = sql.obtenerPagosServicios();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo Pago de Servicio</th>
                        <th class="text-center" >Codigo de Servicio</th>
                        <th class="text-center">Codigo de Sucursal</th>
                        <th class="text-center">Pago de servicio</th>
                        <th class="text-center">Fecha de pago de servicio</th>

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoPagoServicio() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoServicio() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoSucursal() %></td>
                        <td class="align-middle text-center">₡<%=list.get(i).getPagoServicio() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaPago() %></td>
                        <td class="text-center">
                            <form action="EliminarPagoServicio.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deletePagoServicio" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoPagoServicio() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarPagoServicio.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updatePagoServicio" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoPagoServicio() %>">
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
