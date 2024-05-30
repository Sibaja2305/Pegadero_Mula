<%-- 
    Document   : InsertValidationServicio
    Created on : 27/05/2024, 04:50:27 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.text.ParseException"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String nombreServicio = request.getParameter("nombre");
    String fechaString = request.getParameter("fecha");

    java.util.Date utilDate = dateFormat.parse(fechaString);
    // Convertir java.util.Date a java.sql.Date
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

    if (sql.insertarServicio(nombreServicio, sqlDate)) {
        response.sendRedirect("Servicios.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='Servicios.jsp';</script>");
    }

%>