<%-- 
    Document   : ActualizarValidationTipoProducto
    Created on : 31/05/2024, 09:29:52 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%

    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("codigo"));
    
    String nombre = request.getParameter("Nombre");
     

    if (sql.actualizarTipoProducto(codigo, nombre)) {
        response.sendRedirect("TipoProducto.jsp");
    } else {
        out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='TipoProducto.jsp';</script>");
    }

%>
