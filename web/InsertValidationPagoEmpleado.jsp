<%-- 
    Document   : InsertValidationPagoEmpleado
    Created on : 30/05/2024, 10:17:06 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int cEmpleado = Integer.parseInt(request.getParameter("empleado"));
    Date fechaEmision = Date.valueOf(request.getParameter("fechaEmision"));
    Date fechaPago = Date.valueOf(request.getParameter("FechaPago"));
    int cHoraExtra = Integer.parseInt(request.getParameter("horaExtra"));
    int cEstadoPago = Integer.parseInt(request.getParameter("estadoPago"));
    int cBonificacion = Integer.parseInt(request.getParameter("bonificacion"));
    double cMontoPago = Double.parseDouble(request.getParameter("montoPago"));
    double cMontoPagoccss = Double.parseDouble(request.getParameter("montoPagoccss"));
    if (sql.insertarPagoEmpleado(cEmpleado, cHoraExtra, cEstadoPago, fechaEmision, fechaPago, cMontoPago, cMontoPagoccss, cBonificacion)) {
        response.sendRedirect("PagoEmpleado.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewPagoEmpleado.jsp';</script>");
    }

%>
