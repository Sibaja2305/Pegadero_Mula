<%-- 
    Document   : InsertValidationDistrito
    Created on : 26/05/2024, 08:26:57 PM
    Author     : Hp EliteBook
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.SQLException"%>
<%@page import="conexion.Conexion"%>

<%
Conexion sql = new Conexion();

int codigo = Integer.parseInt(request.getParameter("canton"));
String nombre= request.getParameter("nombre");

if (sql.insertarDistrito(codigo, nombre)) {
      response.sendRedirect("Distrito.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewDistrito.jsp';</script>");
}
    
%>

