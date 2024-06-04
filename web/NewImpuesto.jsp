<%-- 
    Document   : NewCaja
    Created on : 27/05/2024, 09:57:01 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Sucursal"%>
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
    <form style="margin-left: 10px"  action= "InsertValidationImpuesto.jsp" method="post">
            <div>
                <h1 class="Title">insertar Impuesto</h1>
            </div>
            
           
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el nombre de impuesto:</label>
                <input type="text" id="nombre" class="form-control" name="nombreImpuesto" placeholder="Nombre" required style="width: 40%">
            </div>
             <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el porcentaje:</label>
                <input type="number" id="porcentaje" class="form-control" name="porcentaje" placeholder="0" required style="width: 40%">
            </div>
           


            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
