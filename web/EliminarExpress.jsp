<%-- 
    Document   : EliminarCanton
    Created on : 26/05/2024, 12:48:47 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarExpress(codigo)) {
        
        
        response.sendRedirect("Express.jsp"); 
    } else {
        // fallo
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Express.jsp';</script>");
    }
%>

