<%-- 
    Document   : EliminarCombo
    Created on : 31/05/2024, 09:58:45 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarCombo(codigo)) {
        
        
        response.sendRedirect("Combo.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Combo.jsp';</script>");
    }
%>
