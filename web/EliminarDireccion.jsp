<%-- 
    Document   : EliminarDireccion
    Created on : 26/05/2024, 10:41:38 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deleteDireccion"));
    
    if (sql.eliminarDireccionFisica(codigo)) {
        
        
        response.sendRedirect("DireccionFisica.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='DireccionFisica.jsp';</script>");
    }
%>
