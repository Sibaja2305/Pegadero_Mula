<%-- 
    Document   : EliminarPagoEmpleado
    Created on : 30/05/2024, 10:24:14 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarPagoEmpleado(codigo)) {
        
        
        response.sendRedirect("PagoEmpleado.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='PagoEmpleado.jsp';</script>");
    }
%>
