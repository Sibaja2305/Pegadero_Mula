<%-- 
    Document   : EliminarProductoIngrediente
    Created on : 31/05/2024, 07:01:47 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int codigoI = Integer.parseInt(request.getParameter("deleteI"));
    int codigoP = Integer.parseInt(request.getParameter("deleteP"));
    if (sql.eliminarProductoIngrediente(codigoI, codigoP)) {
        
        
        response.sendRedirect("ProductoIngrediente.jsp"); 
    } else {
       
        out.println("<script>alert('Este objeto no se puede eliminar'); window.location.href='ProductoIngrediente.jsp';</script>");
    }
%>
