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
     int codigo2 = Integer.parseInt(request.getParameter("delete2"));
    
    if (sql.eliminarComboProducto( codigo2, codigo)) {
        
        
        response.sendRedirect("ComboProducto.jsp"); 
    } else {
        // fallo
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='ComboProducto.jsp';</script>");
    }
%>

