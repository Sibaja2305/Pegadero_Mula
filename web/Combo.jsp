<%-- 
    Document   : Combo
    Created on : 31/05/2024, 09:46:51 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Combo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Combo</h1>
        <a href="NewCombo.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
            <%

                Conexion sql = new Conexion();
                    ArrayList<Combo> list = sql.seleccionarCombos();

            %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de Combo</th>
                        <th class="text-center" >Combo</th>
                       
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoCombo() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreCombo() %></td>
                       
                        <td>
                            <form action="EliminarCombo.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="delete" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoCombo() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                            <form action="ActualizarCombo.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="update" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoCombo() %>">
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
