<%-- 
    Document   : InsertValidationBonificacion
    Created on : 30/05/2024, 01:00:33 PM
    Author     : Hp EliteBook
--%>
<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
     int cEmpleado = Integer.parseInt(request.getParameter("empleado"));
    Date fecha = Date.valueOf(request.getParameter("fecha"));
    double monto = Double.parseDouble(request.getParameter("monton"));
     String motivo = request.getParameter("motivo");
     
    if (sql.insertarBonificacion(fecha, monto, motivo, cEmpleado)) {
        response.sendRedirect("Bonificaciones.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewBonificacion.jsp';</script>");
    }

%>
