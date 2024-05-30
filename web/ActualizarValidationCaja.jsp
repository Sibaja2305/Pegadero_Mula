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
      int codigoCaja = Integer.parseInt(request.getParameter("codigo"));
      int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
     double montoInicial = Double.parseDouble(request.getParameter("montoInicial"));
     double montoFinal = Double.parseDouble(request.getParameter("montoFinal"));
     
     Time horaApertura = Time.valueOf(request.getParameter("horaApertura")+":00");
      Time horaCierre = Time.valueOf(request.getParameter("horaCierre")+":00");
      Date fecha = Date.valueOf(request.getParameter("fecha"));

if (sql.actualizarCaja(codigoCaja, cSucursal, montoInicial, montoFinal, horaApertura, horaCierre, fecha)) {
      response.sendRedirect("Caja.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarCaja.jsp';</script>");
}
    
%>
