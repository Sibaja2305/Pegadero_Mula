<%-- 
    Document   : InsertValidationDetallePedido
    Created on : 31/05/2024, 07:43:46 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>



<%
    Conexion sql = new Conexion();
   
    int codigoPedido = Integer.parseInt(request.getParameter("codigoPedido"));
    System.out.println("codigo en validacion"+codigoPedido);
    int cProducto = Integer.parseInt(request.getParameter("producto"));
    
    int cantidad = Integer.parseInt(request.getParameter("total"));

    if (sql.insertarDetallePedido(codigoPedido, cProducto, cantidad)) {
        response.sendRedirect("DetallePedido.jsp?codigoPedido=" + codigoPedido);
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewDetallePedido.jsp?codigoPedido=" + codigoPedido + "';</script>");
    }

%>
