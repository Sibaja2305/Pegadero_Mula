<%-- 
    Document   : ActualizarValidationDireccion
    Created on : 26/05/2024, 10:58:12 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();

int codigoDireccion = Integer.parseInt(request.getParameter("codigo"));
String nombre= request.getParameter("nombre");
int codigodistrito= Integer.parseInt(request.getParameter("direccion"));
if (sql.actualizarDireccionFisica(codigoDireccion, codigodistrito, nombre)) {
      response.sendRedirect("DireccionFisica.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarDireccion.jsp';</script>");
}
    
%>

