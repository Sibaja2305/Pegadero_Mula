<%-- 
    Document   : EliminarTipoProducto
    Created on : 31/05/2024, 09:25:06 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarTipoProducto(codigo)) {
        
        
        response.sendRedirect("TipoProducto.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='TipoProducto.jsp';</script>");
    }
%>