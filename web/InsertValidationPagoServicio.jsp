<%-- 
    Document   : InsertValidationPagoServicio
    Created on : 27/05/2024, 07:07:52 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    
    int cServicio = Integer.parseInt(request.getParameter("servicio"));
    int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
    double monto = Double.parseDouble(request.getParameter("monto"));
    
    String fechaString = request.getParameter("fecha");
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

            // Parsear la cadena de fecha y hora a un objeto LocalDateTime
            LocalDateTime localDateTime = LocalDateTime.parse(fechaString, formatter);

            // Convertir LocalDateTime a Timestamp
            Timestamp timestamp = Timestamp.valueOf(localDateTime);
    if (sql.insertarPagoServicio(cServicio, cSucursal, monto, timestamp)) {
        response.sendRedirect("PagoServicios.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewPagoServicios.jsp';</script>");
    }

%>
