<%-- 
    Document   : DireccionFisica
    Created on : 26/05/2024, 10:11:00 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.DireccionFisica"%>
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
         <h1>Direccion Fisica</h1>
         <a href="NewDireccion.jsp"> <input style="margin-left: 10px; margin-bottom: 5px" type="submit" class="btn btn-success" value="nuevo" name="newUser" /> </a>
        <%

            Conexion sql = new Conexion();
            ArrayList<DireccionFisica> list = sql.obtenerDireccionesFisicas();
      
        %>
        <div>
            <table  class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Codigo de direccion Fisica</th>
                        <th class="text-center" >Direccion</th>
                        <th class="text-center">Codigo del Distrito</th>
                        

                    </tr>
                </thead>
                <tbody>
                    <% for (int i = 0; i < list.size(); i++) {

                    %>
                    <tr>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoDireccionFisica() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getNombreDireccionFisica() %></td>
                        <td class="align-middle text-center"><%=list.get(i).getCodigoDistrito() %></td>
                        <td class="text-center">
                            <form action="EliminarDireccion.jsp" id="deleteForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="deleteDireccion" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoDireccionFisica() %>">
                                <input                                        
                                    class="btn btn-danger btn-sm" 
                                    type="submit"                                                                              
                                    value="Eliminar" >
                            </form>
                                <form action="ActualizarDireccion.jsp" id="updateForm" method="post">
                                <input 
                                    hidden="true"
                                    type="text" 
                                    name="updatedireccion" 
                                    id="id" 
                                    value="<%=list.get(i).getCodigoDireccionFisica() %>">
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
