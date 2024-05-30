<%-- 
    Document   : ActualizarValidationRol
    Created on : 27/05/2024, 11:01:59 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
       int codigo = Integer.parseInt(request.getParameter("codigo"));
      String dRolEmpleado = request.getParameter("nombre");
     

if (sql.actualizarRolEmpleado(codigo, dRolEmpleado)) {
      response.sendRedirect("RolesEmpleados.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarRolEmpleado.jsp';</script>");
}
    
%>
