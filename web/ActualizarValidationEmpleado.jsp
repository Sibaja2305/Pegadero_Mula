<%-- 
    Document   : ActualizarValidationEmpleado
    Created on : 28/05/2024, 12:33:11 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
       int codigo = Integer.parseInt(request.getParameter("codigo"));
      int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
    int cRol = Integer.parseInt(request.getParameter("rol"));
    int cHoras = Integer.parseInt(request.getParameter("horas"));
     String cedula = request.getParameter("identicacion");
     String nombre = request.getParameter("nombre");
      String primerA = request.getParameter("primerApellido");
      String segundoA = request.getParameter("segundoApellido");
      double salario = Double.parseDouble(request.getParameter("salario"));
      
     

if (sql.actualizarEmpleado(codigo, cRol, cHoras, cSucursal, cedula, nombre, primerA, segundoA, salario)) {
      response.sendRedirect("Empleados.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarEmpleado.jsp';</script>");
}
    
%>
