<%-- 
    Document   : EliminarProveedor
    Created on : 30/05/2024, 11:12:39 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarProveedor(codigo)) {
        
        
        response.sendRedirect("Proveedores.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Proveedores.jsp';</script>");
    }
%>
