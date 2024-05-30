<%-- 
    Document   : InsertValidationRolEmpleado
    Created on : 27/05/2024, 10:53:39 PM
    Author     : Hp EliteBook
--%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
     String cRolEmpleado = request.getParameter("rol");
    
      
    if (sql.insertarRolEmpleado(cRolEmpleado)) {
        response.sendRedirect("RolesEmpleados.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewRolEmpleado.jsp';</script>");
    }

%>