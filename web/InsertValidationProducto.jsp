<%-- 
    Document   : InsertValidationProducto
    Created on : 31/05/2024, 11:40:00 AM
    Author     : Hp EliteBook
--%>
<%@page import="conexion.Conexion"%>



<%
    Conexion sql = new Conexion();
    String comboValue = request.getParameter("combo");
    Integer cCombo = null;
    if (comboValue != null && !comboValue.isEmpty()) {
      
        cCombo = Integer.parseInt(comboValue);
    }
    int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
    int cTipoProducto = Integer.parseInt(request.getParameter("tipoProducto"));
    String nombre = request.getParameter("Nombre");
    double precio = Double.parseDouble(request.getParameter("precio"));

    if (sql.insertarProducto(cCombo, cSucursal, cTipoProducto, nombre, precio)) {
        response.sendRedirect("Producto.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewProducto.jsp';</script>");
    }

%>
