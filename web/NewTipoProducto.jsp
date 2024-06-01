<%-- 
    Document   : NewTipoProducto
    Created on : 31/05/2024, 09:19:30 AM
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
        <form style="margin-left: 10px"  action= "InsertValidationTipoProducto.jsp" method="post">
            <div>
                <h1 class="Title">insertar nuevo Tipo de producto</h1>
            </div>
             
                
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Tipo de producto</label>
                <input type="text" id="text" class="form-control" name="Nombre"  required style="width: 40%">
            </div>
          
           
            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
