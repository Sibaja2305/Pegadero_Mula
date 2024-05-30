<%-- 
    Document   : ActualizarValidationSucursal
    Created on : 27/05/2024, 04:14:30 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
int codigoSucursal = Integer.parseInt(request.getParameter("codigo"));
int codigoDireccion = Integer.parseInt(request.getParameter("direccion"));
String nombre= request.getParameter("nombre");
String telefono= request.getParameter("telefono");
String correo= request.getParameter("correo");
if (sql.actualizarSucursal(codigoSucursal, nombre, telefono, correo, codigoDireccion)) {
      response.sendRedirect("Sucursal.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarSucursal.jsp';</script>");
}
    
%>
