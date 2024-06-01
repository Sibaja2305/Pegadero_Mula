<%-- 
    Document   : InsertValidationTipoProducto
    Created on : 31/05/2024, 09:23:15 AM
    Author     : Hp EliteBook
--%>
<%@page import="conexion.Conexion"%>



<%
    Conexion sql = new Conexion();

    String nombre = request.getParameter("Nombre");
     
     
    if (sql.insertarTipoProducto(nombre)) {
        response.sendRedirect("TipoProducto.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewTipoProducto.jsp';</script>");
    }

%>
