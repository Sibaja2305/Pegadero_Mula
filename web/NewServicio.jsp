<%-- 
    Document   : NewServicio
    Created on : 27/05/2024, 04:47:23 PM
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
    <form style="margin-left: 10px"  action= "InsertValidationServicio.jsp" method="post">
            <div>
                <h1 class="Title">insertar nuevo servicio</h1>
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la sucursal:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="servicio" required Style =" width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite la fecha vencimiento:</label>
                <input type="date" id="nombre" class="form-control" name="fecha" required Style =" width: 40%">
            </div>
            
            

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
