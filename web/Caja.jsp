<%-- 
    Document   : Caja
    Created on : 27/05/2024, 09:52:18 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Caja"%>
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
         <h1>Caja</h1>
         <a href="NewCaja.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<Caja> list = sql.getCaja();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo Caja</th>
                        <th class="text-center" >Codigo de Sucursal</th>
                        <th class="text-center">Monto inicial</th>
                        <th class="text-center">Monto Final</th>
                        <th class="text-center">Hora de apertura</th>
                        <th class="text-center">Hora de cierre</th>

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoCaja() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoSucursal() %></td>
                        <td class="align-middle text-center">₡<%=list.get(i).getMontoInicial() %></td>
                        <td class="align-middle text-center">₡<%=list.get(i).getMontoFinal() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaApertura() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaCierre() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getFechaCaja() %></td>
                        <td class="text-center">
                            <form action="EliminarCaja.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteCaja" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoCaja() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarCaja.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updateCaja" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoCaja() %>">
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
