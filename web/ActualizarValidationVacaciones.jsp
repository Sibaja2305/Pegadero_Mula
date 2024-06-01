<%-- 
    Document   : ActualizarValidationVacaciones
    Created on : 30/05/2024, 02:18:17 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
       int codigo = Integer.parseInt(request.getParameter("codigo"));
      int cEmpleado = Integer.parseInt(request.getParameter("empleado"));
    Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
    Date fechaFin = Date.valueOf(request.getParameter("FechaFin"));
    
     

if (sql.actualizarVacaciones(codigo, cEmpleado, fechaInicio, fechaFin)) {
      response.sendRedirect("Vacaciones.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarVacaciones.jsp';</script>");
}
    
%>
