<%-- 
    Document   : EliminarDistrito
    Created on : 26/05/2024, 08:30:24 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteDistrito"));
    
    if (sql.eliminarDistrito(codigo)) {
        
        
        response.sendRedirect("Distrito.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Distrito.jsp';</script>");
    }
%>
