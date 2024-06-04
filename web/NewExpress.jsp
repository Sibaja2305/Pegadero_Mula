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
        <form style="margin-left: 10px"  action= "InsertValidationExpress.jsp" method="post">
            <div>
                <h1 class="Title">Express</h1>
            </div>
            
            
            
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite el nombre:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="nombre" required Style =" width: 40%">
            </div>
             <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite la direcion del cliente:</label>
                <input type="text" id="direccionCliente" class="form-control" name="direccionCliente" placeholder="Direccion del cliente" required Style =" width: 40%">
            </div>
           

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
