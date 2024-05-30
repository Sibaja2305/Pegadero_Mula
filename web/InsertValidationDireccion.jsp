<%-- 
    Document   : InsertValidationDireccion
    Created on : 26/05/2024, 10:37:13 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
Conexion sql = new Conexion();

int codigo = Integer.parseInt(request.getParameter("direccion"));
String nombre= request.getParameter("nombre");

if (sql.insertarDireccionFisica(codigo, nombre)) {
      response.sendRedirect("DireccionFisica.jsp");    
    }else{
     out.println("<script>alert('no se inserto'); window.location.href='NewDireccion.jsp';</script>");
}
    
%>
