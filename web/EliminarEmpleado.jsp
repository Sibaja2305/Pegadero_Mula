<%-- 
    Document   : EliminarEmpleado
    Created on : 28/05/2024, 12:27:16 AM
    Author     : Hp EliteBook
--%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteEmpleado"));
    
    if (sql.eliminarEmpleado(codigo)) {
        
        
        response.sendRedirect("Empleados.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Empleados.jsp';</script>");
    }
%>