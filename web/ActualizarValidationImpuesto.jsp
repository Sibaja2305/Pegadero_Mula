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
     String nombre= request.getParameter("nombreImpuesto");
     int porcentaje = Integer.parseInt(request.getParameter("porcentaje"));
    

if (sql.actualizarImpuesto(codigo, nombre, porcentaje)) {
      response.sendRedirect("Impuesto.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarImpuesto.jsp';</script>");
}
    
%>
