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

int cliente = Integer.parseInt(request.getParameter("cliente"));
int sucursal = Integer.parseInt(request.getParameter("sucursal"));

if (sql.insertarClienteSucursal(cliente, sucursal)) {
      response.sendRedirect("ClientesSucursales.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewClientesSucursales.jsp';</script>");
}
    
%>