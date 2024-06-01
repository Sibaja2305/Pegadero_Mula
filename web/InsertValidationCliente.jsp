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

int direccion = Integer.parseInt(request.getParameter("direccion"));
String cedula = request.getParameter("cedula");
String numero = request.getParameter("numero");

if (sql.insertarCliente(direccion, cedula, numero)) {
      response.sendRedirect("Cliente.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewCliente.jsp';</script>");
}
    
%>