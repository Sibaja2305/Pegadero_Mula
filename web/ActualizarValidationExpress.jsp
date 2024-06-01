<%-- 
    Document   : ActualizarValidationCanton
    Created on : 26/05/2024, 01:02:02 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
Conexion sql = new Conexion();

int codigo = Integer.parseInt(request.getParameter("codigo"));
String nombre = request.getParameter("nombre");
String direccion = request.getParameter("direccionCliente");

if (sql.actualizarExpress(codigo, nombre, direccion)) {
      response.sendRedirect("Express.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarExpress.jsp';</script>");
}
    
%>
