<%-- 
    Document   : InsertValidationIngrediente
    Created on : 31/05/2024, 12:46:15 AM
    Author     : Hp EliteBook
--%>
<%@page import="conexion.Conexion"%>



<%
    Conexion sql = new Conexion();
    int cSucursal = Integer.parseInt(request.getParameter("sucursal"));
     int proveedor = Integer.parseInt(request.getParameter("proveedor"));
    
    double qvalor = Double.parseDouble(request.getParameter("actual"));
    String nombre = request.getParameter("Nombre");
      int UnidadMedida = Integer.parseInt(request.getParameter("unidad"));
     
    if (sql.insertarIngrediente(cSucursal, proveedor, nombre, qvalor, UnidadMedida)) {
        response.sendRedirect("Ingredientes.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewIngrediente.jsp';</script>");
    }

%>
