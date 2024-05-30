<%-- 
    Document   : EliminarCaja
    Created on : 27/05/2024, 10:14:04 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteCaja"));
    
    if (sql.eliminarCaja(codigo)) {
        
        
        response.sendRedirect("Caja.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Caja.jsp';</script>");
    }
%>