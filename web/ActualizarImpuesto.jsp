<%-- 
    Document   : ActualizarCaja
    Created on : 27/05/2024, 10:17:14 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Clases.Sucursal"%>
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
        
         <%int codigo = Integer.parseInt(request.getParameter("update"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationImpuesto.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar impuesto</h1>
            </div>
            <div class="form-group">
                
                <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            </div>
            
            
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el nombre de impuesto:</label>
                <input type="text" id="nombre" class="form-control" name="nombreImpuesto" placeholder="Nombre" required style="width: 40%">
            </div>
             <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el pporcentaje:</label>
                <input type="number" id="porcentaje" class="form-control" name="porcentaje" placeholder="0" required style="width: 40%">
            </div>
           
            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
