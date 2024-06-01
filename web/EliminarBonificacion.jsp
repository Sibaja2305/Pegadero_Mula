<%-- 
    Document   : EliminarBonificacion
    Created on : 30/05/2024, 01:13:42 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarBonificacion(codigo)) {
        
        
        response.sendRedirect("Bonificaciones.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Bonificaciones.jsp';</script>");
    }
%>
