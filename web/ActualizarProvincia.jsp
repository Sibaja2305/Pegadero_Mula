<%-- 
    Document   : ActualizarProvincia
    Created on : 25/05/2024, 11:37:47 PM
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
        <%int codigo = Integer.parseInt(request.getParameter("updateprovincia"));%>
         <form style="margin-left: 10px"  action= "ActualizarValidationProvincia.jsp" method="post">
            <div>
                <h1 class="Title">Provincia</h1>
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite un nuevo codigo de Provincia:</label>
                <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            </div>

            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Digite el nuevo nombre de la provincia:</label>
                <input type="text" id="nombre" class="form-control" name="nombre" placeholder="nuevo nombre provincia" required Style =" width: 40%">
            </div>
            
            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
