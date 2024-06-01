<%-- 
    Document   : ActualizarValidationEstadoPago
    Created on : 30/05/2024, 04:55:16 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
       int codigo = Integer.parseInt(request.getParameter("codigo"));
     String estado = request.getParameter("estado");
  
    
     

if (sql.actualizarEstadoPago(codigo, estado)) {
      response.sendRedirect("EstadoPago.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='EstadoPago.jsp';</script>");
}
    
%>