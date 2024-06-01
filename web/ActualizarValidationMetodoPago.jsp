<%-- 
    Document   : ActualizarValidationCaja
    Created on : 27/05/2024, 10:20:53 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
      int codigo = Integer.parseInt(request.getParameter("codigo"));
     String metodoPago = request.getParameter("metodoPago");

if (sql.actualizarMetodoPago(codigo, metodoPago)) {
      response.sendRedirect("MetodoPago.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarMetodoPago.jsp';</script>");
}
    
%>
