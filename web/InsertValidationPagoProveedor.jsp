<%-- 
    Document   : InsertValidationPagoProveedor
    Created on : 31/05/2024, 01:25:24 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
 
     int proveedor = Integer.parseInt(request.getParameter("proveedor"));
    
    double qvalor = Double.parseDouble(request.getParameter("actual"));
  
     
    if (sql.insertarPagoProveedor(proveedor, qvalor)) {
        response.sendRedirect("PagoProveedor.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewPagoProveedor.jsp';</script>");
    }

%>