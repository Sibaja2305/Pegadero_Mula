<%-- 
    Document   : Canton
    Created on : 26/05/2024, 12:20:46 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.ComboProducto"%>

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
        <h1>Combo_Producto</h1>
        <a href="NewComboProducto.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                ArrayList<ComboProducto> list = sql.obtenerCombosProductos();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de combo</th>
                        <th class="text-center" >Codigo de producto</th>

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoCombo()%></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoProducto()%></td>

                        <td class="text-center">
                            <form action="EliminarComboProducto.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoCombo()%>">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete2" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoProducto()%>">
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
