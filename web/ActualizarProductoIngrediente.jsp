<%-- 
    Document   : ActualizarProductoIngrediente
    Created on : 31/05/2024, 07:04:20 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Ingredientes"%>
<%@page import="conexion.Conexion"%>
<%@page import="Clases.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Clases.UnidadMedida"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%int codigoI = Integer.parseInt(request.getParameter("updateI"));%>
        <%int codigoP = Integer.parseInt(request.getParameter("updateP"));%>
        
               <form style="margin-left: 10px"  action= "ActualizarValidationProductoIngrediente.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar</h1>
            </div>
            <input  type="text" hidden class="form-control" name="codigoI" value=<%=codigoI%> required Style ="width: 40%" >
             <input  type="text" hidden class="form-control" name="codigoP" value=<%=codigoP%> required Style ="width: 40%" >

            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">cantidad de consumo:</label>
                <input type="text" id="text" class="form-control" name="consumo" pattern="\d+(\.\d+)?" required style="width: 40%">
            </div>
              <select name="unidadMedida">
                <%
                     Conexion sql = new Conexion();
                    ArrayList<UnidadMedida> unidades = sql.seleccionarUnidadesMedida();
                    for (UnidadMedida unidadMedida : unidades) {
                %>
                <option name="unidadMedida" value="<%= unidadMedida.getCodigoUnidadMedida() %>"><%= unidadMedida.getUnidadMedidad() %></option>
                <%
                    }
                %>
            </select>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body> 
</html>
