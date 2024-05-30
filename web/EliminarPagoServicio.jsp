<%-- 
    Document   : EliminarPagoServicio
    Created on : 27/05/2024, 07:51:07 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("deletePagoServicio"));
    
    if (sql.eliminarPagoServicio(codigo)) {
        
        
        response.sendRedirect("PagoServicios.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='PagoServicios.jsp';</script>");
    }
%>