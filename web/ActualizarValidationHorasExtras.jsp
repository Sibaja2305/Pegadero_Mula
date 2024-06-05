<%-- 
    Document   : ActualizarValidationHorasExtras
    Created on : 27/05/2024, 11:42:33 PM
    Author     : Hp EliteBook
--%>
<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>

<%
    
Conexion sql = new Conexion();
       int codigo = Integer.parseInt(request.getParameter("codigo"));
       Date fecha = Date.valueOf(request.getParameter("fecha"));
      int cantidad = Integer.parseInt(request.getParameter("cantidad"));
     

if (sql.actualizarHorasExtra(codigo, fecha, cantidad)) {
      response.sendRedirect("HorasExtras.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarHorasExtras.jsp';</script>");
}
    
%>
