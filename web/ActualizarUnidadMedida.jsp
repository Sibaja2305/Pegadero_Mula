<%-- 
    Document   : ActualizarUnidadMedida
    Created on : 30/05/2024, 11:48:52 PM
    Author     : Hp EliteBook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%int codigo = Integer.parseInt(request.getParameter("update"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationUnidadMedida.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar</h1>
            </div>
            <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >


            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Unidad de Medida:</label>
                <input type="text" id="text" class="form-control" name="Nombre"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Valor:</label>
                <input type="Number" id="text" class="form-control" name="valor"  required style="width: 40%">
            </div>

            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body> 
</html>
