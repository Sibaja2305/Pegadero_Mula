<%-- 
    Document   : InsertValidationEmpleado
    Created on : 28/05/2024, 12:10:32 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
    int cRol = Integer.parseInt(request.getParameter("rol"));
    String horasParam = request.getParameter("horas");
    Integer cHora = null;
    if (cHora != null && !horasParam.isEmpty()) {
      
        cHora = Integer.parseInt(horasParam);
    }

    String cedula = request.getParameter("identicacion");
    String nombre = request.getParameter("nombre");
    String primerA = request.getParameter("primerApellido");
    String segundoA = request.getParameter("segundoApellido");
    double salario = Double.parseDouble(request.getParameter("salario"));
    if (sql.insertarEmpleado(cRol, cHora, cSucursal, cedula, nombre, primerA, segundoA, salario)) {
        response.sendRedirect("Empleados.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewEmpleado.jsp';</script>");
    }

%>