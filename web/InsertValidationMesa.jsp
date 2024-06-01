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

int numero = Integer.parseInt(request.getParameter("numero"));
int capacidad = Integer.parseInt(request.getParameter("capacidad"));


if (sql.insertarMesa(numero, capacidad)) {
      response.sendRedirect("Mesa.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewMesa.jsp';</script>");
}
    
%>