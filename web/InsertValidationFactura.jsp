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
    
    int metodo = Integer.parseInt(request.getParameter("metodoPago"));
    int sucursal = Integer.parseInt(request.getParameter("sucursal"));
    int impuesto = Integer.parseInt(request.getParameter("impuesto"));
    
    
 

    if (sql.insertarFactura(codigoPedido, metodo, sucursal, impuesto)) {
        response.sendRedirect("Factura.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewFactura.jsp?codigoPedido=" + codigoPedido + "';</script>");
    }

%>
