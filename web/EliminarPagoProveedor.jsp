<%-- 
    Document   : EliminarPagoProveedor
    Created on : 31/05/2024, 01:28:13 AM
    Author     : Hp EliteBook
--%>


<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarPagoProveedor(codigo)) {
        
        
        response.sendRedirect("PagoProveedor.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='PagoProveedor.jsp';</script>");
    }
%>