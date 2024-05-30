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

int codigoCanton = Integer.parseInt(request.getParameter("codigo"));
String nombre= request.getParameter("nombre");
int codigoProvincia= Integer.parseInt(request.getParameter("provincia"));
if (sql.actualizarCanton(codigoCanton,codigoProvincia,nombre)) {
      response.sendRedirect("Canton.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarCanton.jsp';</script>");
}
    
%>
