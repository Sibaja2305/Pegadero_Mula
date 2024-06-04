<%-- 
    Document   : NewCanton
    Created on : 26/05/2024, 12:29:16 AM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.DireccionFisica"%>

<%@page import="conexion.Conexion"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form style="margin-left: 10px"  action= "ActualizarValidationMesa.jsp" method="post">
            <div>
                <h1 class="Title">Mesa</h1>
            </div>
             <%int codigo = Integer.parseInt(request.getParameter("update"));%>
             <div class="form-group">
                
                <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            </div>
            
             <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite el numero de mesa:</label>
                <input type="text" id="numero" class="form-control" name="numero" placeholder="nuevo numero de mesa" required Style =" width: 40%">
            </div>
             <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite la capacidad:</label>
                <input type="text" id="capacidad" class="form-control" name="capacidad" placeholder="nueva capacidad" required Style =" width: 40%">
            </div>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
