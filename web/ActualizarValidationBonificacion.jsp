<%-- 
    Document   : ActualizarValidationBonificacion
    Created on : 30/05/2024, 01:20:07 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
       int codigo = Integer.parseInt(request.getParameter("codigo"));
      int cEmpleado = Integer.parseInt(request.getParameter("empleado"));
    Date fecha = Date.valueOf(request.getParameter("fecha"));
    double monto = Double.parseDouble(request.getParameter("monton"));
     String motivo = request.getParameter("motivo");
     

if (sql.actualizarBonificacion(codigo, fecha, monto, motivo, cEmpleado)) {
      response.sendRedirect("Bonificaciones.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarBonificacion.jsp';</script>");
}
    
%>
