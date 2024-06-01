<%-- 
    Document   : InsertValidationVacaciones
    Created on : 30/05/2024, 02:10:20 PM
    Author     : Hp EliteBook
--%>
<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
     int cEmpleado = Integer.parseInt(request.getParameter("empleado"));
    Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
    Date fechaFin = Date.valueOf(request.getParameter("FechaFin"));
     
     
    if (sql.insertarVacaciones(cEmpleado, fechaInicio, fechaFin)) {
        response.sendRedirect("Vacaciones.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewVacaciones.jsp';</script>");
    }

%>
