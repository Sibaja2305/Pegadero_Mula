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

int codigoCliente = Integer.parseInt(request.getParameter("codigo"));
int direccion = Integer.parseInt(request.getParameter("direccion"));
String cedula = request.getParameter("cedula");
String numero = request.getParameter("numero");

if (sql.actualizarCliente(codigoCliente, direccion, cedula, numero)) {
      response.sendRedirect("Cliente.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarCliente.jsp';</script>");
}
    
%>
