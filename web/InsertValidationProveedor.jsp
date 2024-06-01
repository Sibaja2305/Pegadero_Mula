<%-- 
    Document   : InsertValidationProveedor
    Created on : 30/05/2024, 11:05:59 PM
    Author     : Hp EliteBook
--%>


<%@page import="conexion.Conexion"%>
<%
    Conexion sql = new Conexion();
    
    int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
    String proveedor = request.getParameter("Nombre");
     
     
    if (sql.insertarProveedor(cSucursal, proveedor)) {
        response.sendRedirect("Proveedores.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewProveedor.jsp';</script>");
    }

%>
