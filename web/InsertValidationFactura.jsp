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
    
    
 
int codigoFactura = sql.insertarFactura(codigoPedido, metodo, sucursal, impuesto);

    if (codigoFactura != -1) { // Suponiendo que -1 indica que no se insertó correctamente
        response.sendRedirect("VerFactura.jsp?codigoFactura=" + codigoFactura);
        System.out.println("codigo" + codigoFactura);
    } else {
        out.println("<script>alert('No se pudo insertar el pedido'); window.location.href='NewFactura.jsp';</script>"); 
    }

%>