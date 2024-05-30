<%-- 
    Document   : EliminarServicio
    Created on : 27/05/2024, 05:17:46 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteServicio"));
    
    if (sql.eliminarServicio(codigo)) {
        
        
        response.sendRedirect("Servicios.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Servicios.jsp';</script>");
    }
%>