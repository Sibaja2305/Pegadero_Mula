<%-- 
    Document   : InsertValidationHoraExtra
    Created on : 27/05/2024, 11:28:33 PM
    Author     : Hp EliteBook
--%>


<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
     int cantidadHoras = Integer.parseInt(request.getParameter("cantidad"));
    Date fecha = Date.valueOf(request.getParameter("fecha"));
      
    if (sql.insertarHorasExtra(fecha, cantidadHoras)) {
        response.sendRedirect("HorasExtras.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewHoraExtra.jsp';</script>");
    }

%>
