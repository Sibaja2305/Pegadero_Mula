<%-- 
    Document   : InsertValidationCaja
    Created on : 27/05/2024, 10:00:58 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    int mesa = Integer.parseInt(request.getParameter("mesa"));
    int empleado = Integer.parseInt(request.getParameter("empleado"));
    int express = Integer.parseInt(request.getParameter("express"));
    int cliente = Integer.parseInt(request.getParameter("cliente"));
    int sucursal = Integer.parseInt(request.getParameter("sucursal"));
    Time horaSolicitud = Time.valueOf(request.getParameter("horaSolicitud") + ":00");
    Time horaEntrega = Time.valueOf(request.getParameter("horaEntrega") + ":00");

    int codigoPedido = sql.insertarPedido(mesa, empleado, express, cliente, sucursal, horaSolicitud, horaEntrega);

    if (codigoPedido != -1) { // Suponiendo que -1 indica que no se insertó correctamente
        response.sendRedirect("DetallePedido.jsp?codigoPedido=" + codigoPedido);
        System.out.println("codigo" + codigoPedido);
    } else {
        out.println("<script>alert('No se pudo insertar el pedido'); window.location.href='NewPedido.jsp';</script>");
    }

%>