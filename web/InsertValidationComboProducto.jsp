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

int combo = Integer.parseInt(request.getParameter("combo"));
int producto = Integer.parseInt(request.getParameter("producto"));

if (sql.insertarComboProducto(combo, producto)) {
      response.sendRedirect("ComboProducto.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewComboProducto.jsp';</script>");
}
    
%>