<%-- 
    Document   : ActualizarValidationProveedor
    Created on : 30/05/2024, 11:17:37 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
       int codigo = Integer.parseInt(request.getParameter("codigo"));
       int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
    String proveedor = request.getParameter("Nombre");
    
     

if (sql.actualizarProveedor(codigo, cSucursal, proveedor)) {
      response.sendRedirect("Proveedores.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarProveedor.jsp';</script>");
}
    
%>
