<%-- 
    Document   : ActualizarValidationCaja
    Created on : 27/05/2024, 10:20:53 PM
    Author     : Hp EliteBook
--%>

<%@page import="java.sql.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="conexion.Conexion"%>
<%
    
Conexion sql = new Conexion();
      int codigo = Integer.parseInt(request.getParameter("codigo"));
     int mesa = Integer.parseInt(request.getParameter("mesa"));
     int empleado = Integer.parseInt(request.getParameter("empleado"));
     int express = Integer.parseInt(request.getParameter("express"));
     int cliente = Integer.parseInt(request.getParameter("cliente"));
     int sucursal = Integer.parseInt(request.getParameter("sucursal"));
     Time horaSolicitud = Time.valueOf(request.getParameter("horaSolicitud")+":00");
      Time horaEntrega = Time.valueOf(request.getParameter("horaEntrega")+":00");

if (sql.actualizarPedido(codigo, mesa, empleado, express, cliente, sucursal, horaSolicitud, horaEntrega)) {
      response.sendRedirect("Pedido.jsp");    
    }else{
     out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarPedido.jsp';</script>");
}
    
%>
