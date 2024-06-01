<%-- 
    Document   : ActualizarValidationCombo
    Created on : 31/05/2024, 10:06:14 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%

    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("codigo"));
    String nombre = request.getParameter("Nombre");
 

    if (sql.actualizarCombo(codigo, nombre)) {
        response.sendRedirect("Combo.jsp");
    } else {
        out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarCombo.jsp';</script>");
    }

%>
