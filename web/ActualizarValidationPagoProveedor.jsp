<%-- 
    Document   : ActualizarValidationPagoProveedor
    Created on : 31/05/2024, 01:31:36 AM
    Author     : Hp EliteBook
--%>
<%@page import="conexion.Conexion"%>
<%

    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("codigo"));

    int proveedor = Integer.parseInt("proveedor");

    double qvalor = Double.parseDouble(request.getParameter("actual"));
    if (sql.actualizarPagoProveedor(codigo, proveedor, qvalor)) {
        response.sendRedirect("PagoProveedor.jsp");
    } else {
        out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarPagoProveedor.jsp';</script>");
    }

%>