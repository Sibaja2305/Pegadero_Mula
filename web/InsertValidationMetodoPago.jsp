<%-- 
    Document   : InsertValidationCaja
    Created on : 27/05/2024, 10:00:58 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
  String metodoPago = request.getParameter("metodoPago");
      
    if (sql.insertarMetodoPago(metodoPago)) {
        response.sendRedirect("MetodoPago.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewMetodoPago.jsp';</script>");
    }

%>