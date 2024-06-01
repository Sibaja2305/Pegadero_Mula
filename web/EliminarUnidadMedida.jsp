<%-- 
    Document   : EliminarUnidadMedida
    Created on : 30/05/2024, 11:47:13 PM
    Author     : Hp EliteBook
--%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarUnidadMedida(codigo)) {
        
        
        response.sendRedirect("UnidadesMedida.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='UnidadesMedida.jsp';</script>");
    }
%>
