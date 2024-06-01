<%-- 
    Document   : InsertValidationProductoIngrediente
    Created on : 31/05/2024, 06:42:16 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>



<%
    Conexion sql = new Conexion();
    
   
    int cIngrediente = Integer.parseInt(request.getParameter("ingrediente"));
    int cProducto = Integer.parseInt(request.getParameter("producto"));
    double consumo = Double.parseDouble(request.getParameter("consumo"));
    int cUnidadMedida = Integer.parseInt(request.getParameter("unidadMedida"));

    if (sql.insertarProductoIngrediente(cIngrediente, cProducto, consumo, cUnidadMedida)) {
        response.sendRedirect("ProductoIngrediente.jsp");
    } else {
        out.println("<script>alert('no se inserto'); window.location.href='NewProductoIngrediente.jsp';</script>");
    }

%>
