<%-- 
    Document   : EliminarProvincia
    Created on : 25/05/2024, 11:10:16 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteprovincia"));
    
    if (sql.eliminarProvincia(codigo)) {
        
        
        response.sendRedirect("Provincia.jsp"); 
    } else {
        // fallo
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Provincia.jsp';</script>");
    }
%>