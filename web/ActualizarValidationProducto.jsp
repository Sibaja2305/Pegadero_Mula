<%-- 
    Document   : ActualizarValidationProducto
    Created on : 31/05/2024, 05:31:55 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%

    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("codigo"));
    String comboValue = request.getParameter("combo");
    Integer cCombo = null;
    if (comboValue != null && !comboValue.isEmpty()) {

        cCombo = Integer.parseInt(comboValue);
    }
    int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
    int cTipoProducto = Integer.parseInt(request.getParameter("tipoProducto"));
    String nombre = request.getParameter("Nombre");
    double precio = Double.parseDouble(request.getParameter("precio"));
    if (sql.actualizarProducto(codigo, cCombo, cSucursal, cTipoProducto, nombre, precio)) {
        response.sendRedirect("Producto.jsp");
    } else {
        out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarProducto.jsp';</script>");
    }

%>
