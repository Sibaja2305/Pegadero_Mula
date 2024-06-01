<%-- 
    Document   : ActualizarValidationProductoIngrediente
    Created on : 31/05/2024, 07:08:04 PM
    Author     : Hp EliteBook
--%>

<%@page import="conexion.Conexion"%>
<%

    Conexion sql = new Conexion();
    int codigoI = Integer.parseInt(request.getParameter("codigoI"));
    int codigoP = Integer.parseInt(request.getParameter("codigoP"));
  

    int cUnidadMedida = Integer.parseInt(request.getParameter("unidadMedida"));
    
    double consumo = Double.parseDouble(request.getParameter("consumo"));
    if (sql.actualizarProductoIngrediente(codigoI, codigoP, consumo, cUnidadMedida)) {
        response.sendRedirect("ProductoIngrediente.jsp");
    } else {
        out.println("<script>alert('no se actualizo, hubo un error'); window.location.href='ActualizarProductoIngrediente.jsp';</script>");
    }

%>