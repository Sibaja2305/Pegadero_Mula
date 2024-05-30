<%-- 
    Document   : EliminarRolEmpleado
    Created on : 27/05/2024, 10:57:16 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteRol"));
    
    if (sql.eliminarRolEmpleado(codigo)) {
        
        
        response.sendRedirect("RolesEmpleados.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='RolesEmpleados.jsp';</script>");
    }
%>
