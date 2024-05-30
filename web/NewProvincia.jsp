<%-- 
    Document   : insertarPronvincia
    Created on : 25/05/2024, 10:30:48 PM
    Author     : Hp EliteBook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>insertar provincia</title>
    </head>
    <body>
       
        <form style="margin-left: 10px"  action= "InsertValidationProvincia.jsp" method="post">
            <div>
                <h1 class="Title">Provincia</h1>
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite un codigo de Provincia:</label>
                <input type="number" class="form-control" name="codigo" placeholder="ingrese el codigo provincia" required Style ="width: 40%" >
            </div>

            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite el nombre de la provincia:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="nombre provincia" required Style =" width: 40%">
            </div>
            <
            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
