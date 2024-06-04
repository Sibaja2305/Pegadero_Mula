<%-- 
    Document   : NewHoraExtra
    Created on : 27/05/2024, 11:25:15 PM
    Author     : Hp EliteBook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <form style="margin-left: 10px"  action= "InsertValidationHoraExtra.jsp" method="post">
            <div>
                <h1 class="Title">insertar nueva hora extra</h1>
            </div>

            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la fecha de las horas extras:</label>
                <input type="date" id="fecha" class="form-control" name="fecha"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la cantidad de la horas:</label>
                <input type="number" id="fecha" class="form-control" name="cantidad"  required style="width: 40%">
            </div>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
