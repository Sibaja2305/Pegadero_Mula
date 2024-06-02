<%-- 
    Document   : DetallePedido
    Created on : 31/05/2024, 05:53:27 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Factura"%>

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
     
        <h1>Factura</h1>
       
         
            <%

                Conexion sql = new Conexion();
                
                ArrayList<Factura> list = sql.obtenerFacturas();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center" >Codigo de Factura</th>
                        <th class="text-center" >Codigo Pedido</th>
                        <th class="text-center">Codigo Metodo de Mago</th>
                        <th class="text-center" >Codigo de Sucursal</th>
                        <th class="text-center">Codigo de Impuesto</th>
                        <th class="text-center" >Fecha</th>
                        <th class="text-center">Monto Total</th>
                      
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getC_Factura()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getC_Pedido() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getC_Metodo_Pago() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getC_Sucursal() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getC_Impuesto() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getF_Factura() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getM_Total() %></td>
                       
                        <td>
                            <form action="EliminarFactura.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getC_Factura()%>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                           
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
    </body>
</html>
