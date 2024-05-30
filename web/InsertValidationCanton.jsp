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

int codigo = Integer.parseInt(request.getParameter("provincia"));
String nombre= request.getParameter("nombre");

if (sql.insertarCanton(codigo, nombre)) {
      response.sendRedirect("Canton.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewCanton.jsp';</script>");
}
    
%>