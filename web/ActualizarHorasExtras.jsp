<%-- 
    Document   : ActualizarHorasExtras
    Created on : 27/05/2024, 11:39:48 PM
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
        
         <%int codigo = Integer.parseInt(request.getParameter("updateHoras"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationHorasExtras.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar</h1>
            </div>
            <div class="form-group">
                
                <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >
            </div>
            
            
            
           
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Cambio de fecha:</label>
                <input type="date" id="nombre" class="form-control" name="fecha"  required style="width: 40%">
            </div>
           <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Cambio de cantidad de horas:</label>
                <input type="number" id="nombre" class="form-control" name="cantidad"  required style="width: 40%">
            </div>
            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
