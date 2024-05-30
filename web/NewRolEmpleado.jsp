<%-- 
    Document   : NewRolEmpleado
    Created on : 27/05/2024, 10:31:32 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <form style="margin-left: 10px"  action= "InsertValidationRolEmpleado.jsp" method="post">
            <div>
                <h1 class="Title">insertar Rol</h1>
            </div>
           
             <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">digite el nombre del nuevo rol:</label>
                <input type="text" id="monto" class="form-control" name="rol"  required style="width: 40%">
            </div>


            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
