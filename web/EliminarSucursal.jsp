<%-- 
    Document   : EliminarSucursal
    Created on : 27/05/2024, 04:02:55 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteSucursal"));
    
    if (sql.eliminarSucursal(codigo)) {
        
        
        response.sendRedirect("Sucursal.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Sucursal.jsp';</script>");
    }
%>
