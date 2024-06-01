<%-- 
    Document   : DetallePedido
    Created on : 31/05/2024, 05:53:27 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.DetallePedido"%>
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
         <%int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));%>
        <h1>Detalle pedido</h1>
        <form action="NewDetallePedido.jsp">
         <input  type="text" hidden class="form-control" name="codigoPedido" value=<%=codigoPedido%> required Style ="width: 40%" >
        <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Nuevo Pedido</button>
        </div>
        </form>
         
            <%

                Conexion sql = new Conexion();
                
                ArrayList<DetallePedido> list = sql.seleccionarDetallesPedido(codigoPedido);

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center" >Codigo</th>
                        <th class="text-center" >Codigo Pedido</th>
                        <th class="text-center">Producto</th>
                        <th class="text-center" >Cantidad</th>
                        <th class="text-center">Precio</th>
                      
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoDetallePedido() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoPedido() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreProducto() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCantidadProducto() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getMontoTotal() %></td>
                       
                        <td>
                            <form action="EliminarDetallePedido.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProducto()%>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarDetallePedido.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProducto()%>">
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
