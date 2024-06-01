<%-- 
    Document   : InsertEstadoPago
    Created on : 30/05/2024, 04:48:27 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
     String estado = request.getParameter("estado");
   
     
    if (sql.insertarEstadoPago(estado)) {
        response.sendRedirect("EstadoPago.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewEstadoPago.jsp';</script>");
    }

%>
