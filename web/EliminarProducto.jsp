<%-- 
    Document   : EliminarProducto
    Created on : 31/05/2024, 05:23:09 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarProducto(codigo)) {
        
        
        response.sendRedirect("Producto.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Producto.jsp';</script>");
    }
%>