<%-- 
    Document   : ActualizarValidationIngrediente
    Created on : 31/05/2024, 12:57:27 AM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%

    Conexion sql = new Conexion();
    int codigo = Integer.parseInt(request.getParameter("codigo"));
    int cSucursal = Integer.parseInt("sucursal");
     int proveedor = Integer.parseInt("proveedor");
    
    double qvalor = Double.parseDouble(request.getParameter("actual"));
    String nombre = request.getParameter("Nombre");
      int UnidadMedida = Integer.parseInt("unidad");

    if (sql.actualizarIngrediente(codigo, cSucursal, proveedor, nombre, qvalor, UnidadMedida)) {
        response.sendRedirect("Ingredientes.jsp");
    } else {
        out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarIngrediente.jsp';</script>");
    }

%>
