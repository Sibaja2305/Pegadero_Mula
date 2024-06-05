<%-- 
    Document   : PagoEmpleado
    Created on : 30/05/2024, 09:30:48 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.PagoEmpleado"%>
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
        <h1>Empleados</h1>
        <a href="NewPagoEmpleado.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                ArrayList<PagoEmpleado> list = sql.seleccionarPagosEmpleados();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de pago empleado</th>
                        <th class="text-center" >Codigo de Empleado</th>
                        <th class="text-center" >Codigo de Hora extras</th>
                        <th class="text-center" >Codigo Estado de pago</th>
                        <th class="text-center" >Fecha de emision</th>
                        <th class="text-center" >Fecha de Pago</th>
                        <th class="text-center" >Monto de pago</th>
                        <th class="text-center" >Monto de pago de la CCSS</th>
                        <th class="text-center" >Codigo de bonificacion</th>


                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoPagoEmpleado()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoEmpleado()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoHorasExtras()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoEstadoPago()%></td> 
                        <td class="align-middle text-center"><%=list.get(i).getFechaEmision() %></td> 
                        <td class="align-middle text-center"><%=list.get(i).getFechaPago() %></td> 
                        <td class="align-middle text-center"><%=list.get(i).getMontonPago() %></td> 
                        <td class="align-middle text-center"><%=list.get(i).getMontoPagoCCSS() %></td> 
                        <td class="align-middle text-center"><%=list.get(i).getCodigoBonificacion() %></td> 
                        <td>
                            <form action="EliminarPagoEmpleado.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoPagoEmpleado() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarPagoEmpleado.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoPagoEmpleado()%>">
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
