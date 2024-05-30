<%-- 
    Document   : InsertValidation
    Created on : 25/05/2024, 10:35:37 PM
    Author     : Hp EliteBook
--%>
<%@page import="java.sql.SQLException"%>
<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
Conexion sql = new Conexion();

int codigo = Integer.parseInt(request.getParameter("codigo"));
String nombre= request.getParameter("nombre");

if (sql.insertarProvincia(codigo, nombre)) {
      response.sendRedirect("Provincia.jsp");    
    }else{
     out.println("<script>alert('se inserto correctamente'); window.location.href='NewProvincia.jsp';</script>");
}
    
%>
