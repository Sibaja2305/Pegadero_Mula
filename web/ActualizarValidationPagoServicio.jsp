<%-- 
    Document   : ActualizarValidationPagoServicio
    Created on : 27/05/2024, 09:14:56 PM
    Author     : Hp EliteBook
--%>
<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();

int codigoPagoServicio = Integer.parseInt(request.getParameter("codigo"));
int codigoServicio = Integer.parseInt(request.getParameter("servicio"));
int codigoSucursal= Integer.parseInt(request.getParameter("sucursal"));
double monto = Double.parseDouble(request.getParameter("monto"));

if (sql.actualizarPagoServicio(codigoPagoServicio, codigoServicio, codigoSucursal, monto)) {
      response.sendRedirect("PagoServicios.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarPagoServicio.jsp';</script>");
}
    
%>
