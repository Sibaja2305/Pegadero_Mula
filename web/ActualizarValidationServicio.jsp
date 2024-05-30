<%-- 
    Document   : ActualizarValidationServicio
    Created on : 27/05/2024, 05:46:45 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
int codigoServicio = Integer.parseInt(request.getParameter("codigo"));
String nombre = request.getParameter("nombre");
String fecha= request.getParameter("fecha");
java.util.Date utilDate = dateFormat.parse(fecha);
    // Convertir java.util.Date a java.sql.Date
    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
if (sql.actualizarServicio(codigoServicio, nombre, sqlDate)) {
      response.sendRedirect("Servicio.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarServicio.jsp';</script>");
}
    
%>
