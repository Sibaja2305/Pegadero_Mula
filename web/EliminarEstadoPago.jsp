<%-- 
    Document   : EliminarEstadoPago
    Created on : 30/05/2024, 04:52:39 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarEstadoPago(codigo)) {
        
        
        response.sendRedirect("EstadoPago.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='EstadoPago.jsp';</script>");
    }
%>
