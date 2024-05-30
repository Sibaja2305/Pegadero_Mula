<%-- 
    Document   : InsertValidationSucursal
    Created on : 26/05/2024, 11:55:50 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
Conexion sql = new Conexion();

int codigo = Integer.parseInt(request.getParameter("direccion"));
String nombre= request.getParameter("nombre");
String telefono= request.getParameter("telefono");
String correo= request.getParameter("correo");

if (sql.insertarSucursal(nombre, telefono, correo, codigo)) {
      response.sendRedirect("Sucursal.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewSucursal.jsp';</script>");
}
    
%>
