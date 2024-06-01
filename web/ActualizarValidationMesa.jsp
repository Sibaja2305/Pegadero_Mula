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
int numero = Integer.parseInt(request.getParameter("numero"));
int capacidad = Integer.parseInt(request.getParameter("capacidad"));

if (sql.actualizarMesa(codigo, numero, capacidad)) {
      response.sendRedirect("Mesa.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarMesa.jsp';</script>");
}
    
%>
