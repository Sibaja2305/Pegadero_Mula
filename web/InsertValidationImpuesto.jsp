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
    
     String nombre= request.getParameter("nombreImpuesto");
     int porcentaje = Integer.parseInt(request.getParameter("porcentaje"));
    
    
    if (sql.insertarImpuesto(nombre, porcentaje)) {
        response.sendRedirect("Impuesto.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewImpuesto.jsp';</script>");
    }

%>