<%-- 
    Document   : EliminarIngrediente
    Created on : 31/05/2024, 12:52:34 AM
    Author     : Hp EliteBook
--%>


<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarIngrediente(codigo)) {
        
        
        response.sendRedirect("Ingredientes.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='Ingredientes.jsp';</script>");
    }
%>