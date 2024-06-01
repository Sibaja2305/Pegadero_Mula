<%-- 
    Document   : InsertValidationCanton
    Created on : 26/05/2024, 12:41:59 AM
    Author     : Hp EliteBook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conexion.Conexion"%>

<%
Conexion sql = new Conexion();


String nombre = request.getParameter("nombre");
String direccion = request.getParameter("direccionCliente");

if (sql.insertarExpress(nombre, direccion)) {
      response.sendRedirect("Express.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewExpress.jsp';</script>");
}
    
%>