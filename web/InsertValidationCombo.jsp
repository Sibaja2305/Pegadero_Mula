<%-- 
    Document   : InsertValidationCombo
    Created on : 31/05/2024, 09:55:59 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>



<%
    Conexion sql = new Conexion();
   
    String nombre = request.getParameter("Nombre");
    
     
    if (sql.insertarCombo(nombre)) {
        response.sendRedirect("Combo.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewCombo.jsp';</script>");
    }

%>
