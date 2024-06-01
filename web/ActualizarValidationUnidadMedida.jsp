<%-- 
    Document   : ActualizarValidationUnidadMedida
    Created on : 30/05/2024, 11:53:25 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%

    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("codigo"));
    double qvalor = Double.parseDouble(request.getParameter("valor"));
    String nombre = request.getParameter("Nombre");

    if (sql.actualizarUnidadMedida(codigo, nombre, qvalor)) {
        response.sendRedirect("UnidadesMedida.jsp");
    } else {
        out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarUnidadMedida.jsp';</script>");
    }

%>
