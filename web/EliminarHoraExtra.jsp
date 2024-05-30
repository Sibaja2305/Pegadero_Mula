<%-- 
    Document   : EliminarHoraExtra
    Created on : 27/05/2024, 11:37:49 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteHoras"));
    
    if (sql.eliminarHorasExtra(codigo)) {
        
        
        response.sendRedirect("HorasExtras.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='HorasExtras.jsp';</script>");
    }
%>