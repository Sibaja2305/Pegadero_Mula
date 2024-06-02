<%-- 
    Document   : EliminarCanton
    Created on : 26/05/2024, 12:48:47 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Conexion sql = new Conexion();
     int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));
    int codigo = Integer.parseInt(request.getParameter("delete"));
    
    if (sql.eliminarDetallePedido(codigo)) {
        response.sendRedirect("DetallePedido.jsp?codigoPedido=" + codigoPedido);
    } else {
        out.println("<script>alert('no se elimino'); window.location.href='DetallePedido.jsp?codigoPedido=" + codigoPedido + "';</script>");
    }
    
%>

