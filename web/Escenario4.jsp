<%-- 
    Document   : Escenario4
    Created on : 25 jun. 2024, 18:57:02
    Author     : yorda
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
      boolean bool = true;
    int mesa = 5;
    int empleado = 4;
    int express = 0 ;
    int cliente = 7;
    int sucursal = 1;
    Time horaSolicitud = Time.valueOf("11:40:00");
    Time horaEntrega = Time.valueOf("11:45:00");

    int codigoPedido = sql.insertarPedido(mesa, empleado, express, cliente, sucursal, horaSolicitud, horaEntrega);

    if (codigoPedido != -1) { // Suponiendo que -1 indica que no se insert� correctamente
        if (sql.insertarDetallePedido(codigoPedido, 1, 5)) {
            System.out.println("se inserto detalle de pedido");
        } else {
             bool = false;
            out.println("<script>alert('no se inserto');';</script>");
        }
         if (sql.insertarDetallePedido(codigoPedido, 10, 2)) {
            System.out.println("se inserto detalle de pedido");
        } else {
             bool = false;
            out.println("<script>alert('no se inserto');';</script>");
        }
         if (sql.insertarDetallePedido(codigoPedido, 11, 3)) {
            System.out.println("se inserto detalle de pedido");
        } else {
             bool = false;
            out.println("<script>alert('no se inserto');';</script>");
        }
         if (sql.insertarDetallePedido(codigoPedido, 3, 1)) {
            System.out.println("se inserto detalle de pedido");
        } else {
              bool = false;
            out.println("<script>alert('no se inserto');';</script>");
        }
        int codigoFactura = sql.insertarFactura(codigoPedido, 2, sucursal, 1);

        if (codigoFactura != -1 && bool) { // Suponiendo que -1 indica que no se insert� correctamente
            response.sendRedirect("VerFactura.jsp?codigoFactura=" + codigoFactura);
            System.out.println("codigo" + codigoFactura);
        } else {
            out.println("<script>alert('No se pudo insertar el pedido'); window.location.href='Dashboard.jsp';</script>");
        }
    } else {
        out.println("<script>alert('No se pudo insertar el pedido'); window.location.href='Dashboard.jsp';</script>");
    }

%>