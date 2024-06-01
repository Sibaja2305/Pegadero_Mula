<%-- 
    Document   : InsertValidationUnidadMedida
    Created on : 30/05/2024, 11:44:25 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    
    double qvalor = Double.parseDouble(request.getParameter("valor"));
    String nombre = request.getParameter("Nombre");
     
     
    if (sql.insertarUnidadMedida(nombre, qvalor)) {
        response.sendRedirect("UnidadesMedida.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewUnidadMedida.jsp';</script>");
    }

%>