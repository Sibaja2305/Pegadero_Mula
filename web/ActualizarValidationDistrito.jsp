<%-- 
    Document   : ActualizarValidationDistrito
    Created on : 26/05/2024, 09:42:26 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    
Conexion sql = new Conexion();

int codigoDistrito = Integer.parseInt(request.getParameter("codigo"));
String nombre= request.getParameter("nombre");
int codigoCanton= Integer.parseInt(request.getParameter("canton"));
if (sql.actualizarDistrito(codigoDistrito, codigoCanton, nombre)) {
      response.sendRedirect("Distrito.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarCanton.jsp';</script>");
}
    
%>
