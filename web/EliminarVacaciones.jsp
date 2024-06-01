<%-- 
    Document   : EliminarVacaciones
    Created on : 30/05/2024, 02:13:06 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarVacaciones(codigo)) {
        
        
        response.sendRedirect("Vacaciones.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Vacaciones.jsp';</script>");
    }
%>
