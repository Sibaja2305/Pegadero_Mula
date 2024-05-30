<%-- 
    Document   : ActualizarValidationProvincia
    Created on : 25/05/2024, 11:42:14 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Conexion sql = new Conexion();

int codigo = Integer.parseInt(request.getParameter("codigo"));
String nombre= request.getParameter("nombre");

if (sql.actualizarProvincia(codigo, nombre)) {
      response.sendRedirect("Provincia.jsp");    
    }else{
     out.println("<script>alert('se inserto correctamente'); window.location.href='ActualizarProvincia.jsp';</script>");
}
    
%>
