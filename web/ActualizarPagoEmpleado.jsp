<%-- 
    Document   : ActualizarPagoEmpleado
    Created on : 30/05/2024, 10:25:27 PM
    Author     : Hp EliteBook
--%>

<%@page import="Clases.Bonificacion"%>
<%@page import="Clases.EstadoPago"%>
<%@page import="Clases.HorasExtras"%>
<%@page import="Clases.Empleado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
   <body>
       <%int codigo = Integer.parseInt(request.getParameter("update"));%>
        <form style="margin-left: 10px"  action= "ActualizarValidationPagoEmpleado.jsp" method="post">
            <div>
                <h1 class="Title">Actualizar</h1>
            </div>
              <input  type="text" hidden class="form-control" name="codigo" value=<%=codigo%> required Style ="width: 40%" >

          <select name="empleado">
                <%
                    Conexion sql = new Conexion();
                    ArrayList<Empleado> empleados = sql.seleccionarEmpleados();
                    for (Empleado empleado : empleados) {
                %>
                <option name="empleado" value="<%= empleado.getCodigoEmpleado() %>"><%= empleado.getNombre() %></option>
                <%
                    }
                %>
            </select>
             <select name="horaExtra">
                <%
                    
                    ArrayList<HorasExtras> horas = sql.getHorasExtra();
                    for (HorasExtras hora : horas) {
                %>
                <option name="horaExtra" value="<%= hora.getCodigoHoraExtra() %>"><%= hora.getCantidadHoras() %></option>
                <%
                    }
                %>
            </select>
            <select name="estadoPago">
                <%
                    
                    ArrayList<EstadoPago> estados = sql.seleccionarEstadoPago();
                    for (EstadoPago estado : estados) {
                %>
                <option name="estadoPago" value="<%= estado.getCodigoEstadoPago() %>"><%= estado.getEstadoPago() %></option>
                <%
                    }
                %>
            </select>
            
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">seleccione la fecha de emision:</label>
                <input type="date" id="text" class="form-control" name="fechaEmision"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">selecione la fecha de Pago :</label>
                <input type="date" id="text" class="form-control" name="FechaPago"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Monto de Pago :</label>
                <input type="Number" id="text" class="form-control" name="montoPago"  required style="width: 40%">
            </div>
            <div class="form-group">
                <label class="labels" style="margin-bottom: 5px; margin-top: 10px">Monto de Pago de la CCSS :</label>
                <input type="Number" id="text" class="form-control" name="montoPagoccss"  required style="width: 40%">
            </div>
            <select name="bonificacion">
                <%
                    
                    ArrayList<Bonificacion> bonificaciones = sql.seleccionarBonificaciones();
                    for (Bonificacion bonificacion : bonificaciones) {
                %>
                <option name="bonificacion" value="<%= bonificacion.getCodigoBonificacion() %>"><%= bonificacion.getMontoBonificacion() %></option>
                <%
                    }
                %>
            </select>
            
            <div style="float: left; margin-top: 25px">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </body>
</html>
